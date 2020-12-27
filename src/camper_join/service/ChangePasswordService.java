package camper_join.service;

import java.sql.Connection;

import java.sql.SQLException;

import db.ConnectionProvider;
import db.DBUtil;
import module.dao.CamperDao;
import module.model.Camper;

public class ChangePasswordService {
	private CamperDao camperDao = new CamperDao();
	
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Camper camper = camperDao.selectById(conn, userId);
			if(camper == null) {
				throw new MemberNotFoundException();
			}
			if(!camper.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			
			camper.changePassword(newPwd);
			camperDao.update(conn, camper);
			conn.commit();
			} catch (SQLException e) {
				DBUtil.rollback(conn);
				throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}
}
