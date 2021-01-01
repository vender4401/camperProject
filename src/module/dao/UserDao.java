package module.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBUtil;
import module.model.CamperUser;

public class UserDao {
	
public static CamperUser userInfo(Connection con, String id) throws SQLException {
		
		CamperUser camperUser = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, name, gender, birth, phone, email, "
				+ "FROM camper "
				+ "WHERE id=?";		
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				camperUser = new CamperUser();
				camperUser.setUserId(rs.getString(1));
				camperUser.setUserName(rs.getString(2));
				camperUser.setUserGender(rs.getString(3));
				camperUser.setUserBirth(rs.getString(4));								
				camperUser.setUserPhone(rs.getString(5));
				camperUser.setUserEmail(rs.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(rs, pstmt);
		}
		
		
		return camperUser;
	}
}
