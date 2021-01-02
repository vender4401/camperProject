package module.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBUtil;
import module.model.Camper;


public class CamperDao2 {
	
	
	
	
	public void delete(Connection con, String id) throws SQLException {
		// 삭제 쿼리 실행
		String sql = "DELETE camper WHERE id = ?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, id);
					
			pstmt.executeUpdate();
		}
	}
	
	
	public Camper selectById(Connection con, String id) throws SQLException {
		
		Camper camper = null;
		
		String sql = "SELECT id, name, gender, birth, phone, email, "
				+ "password, password2, regdate "
				+ "FROM camper "
				+ "WHERE id=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				camper = new Camper();
				camper.setId(rs.getString(1));
				camper.setName(rs.getString(2));
				camper.setGender(rs.getString(3));
				camper.setBirth(rs.getString(4));
								
				camper.setPhone(rs.getString(5));

				camper.setEmail(rs.getString(6));
				
				camper.setPassword(rs.getString(7));
				camper.setPassword2(rs.getString(8));
				camper.setRegDate(rs.getTimestamp(9));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(rs, pstmt);
		}
		
		
		return camper;
	}
	
	public void insert(Connection con, Camper camper) throws SQLException {
		String sql = "INSERT INTO camper "
				+ "(id, name, gender, birth, phone, email, password, password2, regdate) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, SYSDATE) ";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, camper.getId());
			pstmt.setString(2, camper.getName());
			pstmt.setString(3, camper.getGender());
			pstmt.setString(4, camper.getBirth());
			
			pstmt.setString(5, camper.getPhone());
	
			pstmt.setString(6, camper.getEmail());

			pstmt.setString(7, camper.getPassword());
			pstmt.setString(8, camper.getPassword2());			
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(pstmt);
		}
		
	}

	
	public void update(Connection con, Camper camper) throws SQLException {
			String sql = "UPDATE camper SET name=?, password=? WHERE id=?";
			
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, camper.getName());
				pstmt.setString(2, camper.getPassword());
				pstmt.setString(3, camper.getId());
				
				pstmt.executeUpdate();
			}
		}
	
	public void updateName(Connection con, Camper camper) throws SQLException {
		String sql = "UPDATE camper SET name=?, password=? WHERE id=?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, camper.getName());
			pstmt.setString(2, camper.getPassword());
			pstmt.setString(3, camper.getId());
			
			pstmt.executeUpdate();
		}
	}
	
}
