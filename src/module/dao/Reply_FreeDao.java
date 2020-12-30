package module.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import module.model.Reply;


public class Reply_FreeDao {
	
	public void insert(Connection con, String userId, int boardNo, String body) throws SQLException {
		String sql = "INSERT INTO reply_free "
				+ "(memberid, board_no, body, regdate) "
				+ "VALUES (?, ?, ?, SYSDATE)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, userId);
			pstmt.setInt(2, boardNo);
			pstmt.setString(3, body);
			
			pstmt.executeUpdate();
		}
		
	}

	public List<Reply> listReply(Connection con, int boardNum) throws SQLException {
		String sql = "SELECT replyid, memberid, board_no, body, regdate "
				+ "    FROM reply_free "
				+ "    WHERE board_no=? "
				+ "    ORDER BY replyid DESC";
		
		List<Reply> list = new ArrayList<>();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, boardNum);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reply r = new Reply();
				r.setId(rs.getInt(1));
				r.setMemberId(rs.getString(2));
				r.setBoard_FreeNum(rs.getInt(3));
				r.setBody(rs.getString(4));
				r.setRegDate(rs.getTimestamp(5));
				
				list.add(r);
			}
			
		}
		return list;
	}
}
