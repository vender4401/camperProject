package module.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBUtil;
import module.model.Board_Content;



public class Board_ContentDao {
	
	public Board_Content selectById(Connection con, int no) throws SQLException {
		String sql = "SELECT * FROM board_content "
				+ "WHERE board_no=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Board_Content content = null;
			if (rs.next()) {
				content = new Board_Content(rs.getInt("board_no"),
						rs.getString("content"));						
			}
			return content;
		} finally {
			DBUtil.close(rs, pstmt);
		}		
	}
	
	public Board_Content insert(Connection con, Board_Content content) 
			throws SQLException {
			
			String sql = "INSERT INTO board_content (board_no, content) "
					+ "VALUES (?, ?)";
			
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, content.getNumber());
				pstmt.setString(2, content.getContent());
				
				int cnt = pstmt.executeUpdate();
				
				if (cnt == 1) {
					return content;
				} else {
					return null;
				}
			}
		}
}
