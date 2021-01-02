package module.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBUtil;
import module.model.Board_Content2;

public class Board_ContentDao2 {
	public int update(Connection conn, int no, String content) throws SQLException {
		String sql = "UPDATE trade_content SET content=? "
				+ "WHERE board_no=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			
			int cnt = pstmt.executeUpdate();
			return cnt;
		}
	}
	
	public void delete(Connection con, int no) throws SQLException {
		String sql = "DELETE trade_content WHERE board_no=?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		}
	}
	
	public Board_Content2 selectById(Connection con, int no) throws SQLException {
		String sql = "SELECT * FROM trade_content "
				+ "WHERE board_no=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Board_Content2 content = null;
			if (rs.next()) {
				content = new Board_Content2(rs.getInt("board_no"),
						rs.getString("content"));						
			}
			return content;
		} finally {
			DBUtil.close(rs, pstmt);
		}		
	}
	
	public Board_Content2 insert(Connection con, Board_Content2 content) 
			throws SQLException {
			
			String sql = "INSERT INTO trade_content (board_no, content) "
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
