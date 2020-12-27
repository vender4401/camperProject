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
import module.model.Writer;

public class Board_FreeDao {	
	
	public List<Board_Free> select(Connection con, int pageNum, int size) throws SQLException {			
			
			String sql = "SELECT rn, board_no, writer_id, writer_name, "
					+ "title, regdate, moddate, read_cnt, recommend_cnt "
	                + "FROM (SELECT board_no, writer_id, writer_name, title, "
	                + "regdate, moddate, read_cnt, recommend_cnt, ROW_NUMBER() "
	                + "OVER (ORDER BY board_no DESC) rn FROM board_free ) "
	                + "WHERE rn BETWEEN ? AND ?";
			
			/*
			String sql = "SELECT * FROM article ORDER BY article_no DESC "
					+ "LIMIT ?, ?";
					// 시작 row_num(zerobase), 갯수
			*/
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (pageNum-1) * size + 1);
				pstmt.setInt(2, pageNum * size);
				
				rs = pstmt.executeQuery();
				List<Board_Free> result = new ArrayList<>();
				while (rs.next()) {
					result.add(convertArticle(rs));
				}
				
				return result;
			} finally {
				DBUtil.close(rs, pstmt);
			}
		}
	
	private Board_Free convertArticle(ResultSet rs) throws SQLException {
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
