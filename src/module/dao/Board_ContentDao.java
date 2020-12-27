package module.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import module.model.Board_Content;



public class Board_ContentDao {
	
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
