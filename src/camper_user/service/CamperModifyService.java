package camper_user.service;

import java.sql.Connection;
import java.sql.SQLException;

import camper_join.service.InvalidPasswordException;
import camper_join.service.MemberNotFoundException;
import db.ConnectionProvider;
import db.DBUtil;
import module.dao.CamperDao;
import module.model.Camper;

public class CamperModifyService {
private CamperDao camperDao = new CamperDao();
	
	public void changeCamper(String userId, String curPwd, String newName) {
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
			
			camper.changeId(newName);
			camperDao.updateName(conn, camper);
			conn.commit();
			} catch (SQLException e) {
				DBUtil.rollback(conn);
				throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}
}
