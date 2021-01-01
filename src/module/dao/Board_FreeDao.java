package module.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.DBUtil;
import module.model.Board_Free;
import module.model.Reply_Free;
import module.model.Writer;

public class Board_FreeDao {	
	
	public void delete(Connection con, int no) throws SQLException {
		String sql = "DELETE board_Free WHERE board_no=?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		}
	}
	
	public int update(Connection con, int no, String title) throws SQLException {
		String sql = "UPDATE board_Free SET title=?, moddate=SYSDATE "
				+ "WHERE board_no=?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setInt(2, no);
			
			int cnt = pstmt.executeUpdate();
			return cnt;
		}
	}
	
	public Board_Free selectById(Connection con, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_free WHERE board_no=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			Board_Free board_Free = null;
			
			if(rs.next()) {
				board_Free = convertBoard_Free(rs);
			}
			return board_Free;
		} finally {
			DBUtil.close(rs, pstmt);
		}
	}
	
	public void increaseReadCount(Connection con, int no) throws SQLException {
		try (PreparedStatement pstmt = con.prepareStatement(
				"UPDATE board_free SET read_cnt=read_cnt+1 "
						+ "WHERE board_no=?"
				)) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}			
	}
	
	public List<Reply_Free> select(Connection con, int pageNum, int size) throws SQLException {			
			
			String sql = "SELECT rn, board_no, writer_id, writer_name, "
					+ "title, regdate, moddate, read_cnt, reply_cnt "
	                + "FROM (SELECT board_no, writer_id, writer_name, title, "
	                + "regdate, moddate, read_cnt, ROW_NUMBER() "
	                + "OVER (ORDER BY board_no DESC) rn, "
	                + "(SELECT COUNT(*) FROM reply_free A WHERE A.board_no=B.board_no) AS reply_cnt "
	                + "FROM board_free B) "
	                + "WHERE rn BETWEEN ? AND ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (pageNum-1) * size + 1);
				pstmt.setInt(2, pageNum * size);
				
				rs = pstmt.executeQuery();
				List<Reply_Free> result = new ArrayList<>();
				while (rs.next()) {
					Reply_Free rf = new Reply_Free();
					rf.setModdate(rs.getDate("moddate"));
					rf.setNumber(rs.getInt("board_no"));
					rf.setReadCount(rs.getInt("read_cnt"));
					rf.setRegdate(rs.getDate("regdate"));
					rf.setReplyCount(rs.getInt("reply_cnt"));
					rf.setTitle(rs.getString("title"));
					rf.setWriter(new Writer(rs.getString("writer_id"),
										rs.getString("writer_name")));
					result.add(rf);
				}
				
				return result;
			} finally {
				DBUtil.close(rs, pstmt);
			}
		}
	
	private Board_Free convertBoard_Free(ResultSet rs) throws SQLException {
		return new Board_Free(rs.getInt("board_no"),
					new Writer(
							rs.getString("writer_id"),
							rs.getString("writer_name")
							),
					rs.getString("title"),
					rs.getTimestamp("regdate"),
					rs.getTimestamp("moddate"),
					rs.getInt("read_cnt"), 
					rs.getInt("recommend_cnt")
				);
	}

	public int selectCount(Connection con) throws SQLException {
		String sql = "SELECT COUNT(*) FROM board_free";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally { 
			DBUtil.close(rs, stmt);
		}
	}

	public Board_Free insert(Connection con, Board_Free board_free) 
			throws SQLException {
		// 12c 이상
		String sql = "INSERT INTO board_free "
				+ "(writer_id, writer_name, title, regdate, moddate, read_cnt, recommend_cnt) "
				+ "VALUES (?, ?, ?, SYSDATE, SYSDATE, 0, 0)";
		

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql,
							new String[] {"board_no", "regdate", "moddate"});
			
			pstmt.setString(1, board_free.getWriter().getId());
			pstmt.setString(2, board_free.getWriter().getName());
			pstmt.setString(3, board_free.getTitle());
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt == 1) {
				rs = pstmt.getGeneratedKeys();
				int key = 0;
				Date regDate = null;
				Date modDate = null;
				if (rs.next()) {
					key = rs.getInt(1);
					regDate = rs.getTimestamp(2);
					modDate = rs.getTimestamp(3);
				}
				return new Board_Free(key,
						board_free.getWriter(),
						board_free.getTitle(),
						regDate,
						modDate,
						0, 0);
			} else {
				return null;
			}
		} finally {
			DBUtil.close(rs, pstmt);
		}
	}
	
}
