package camper_join.service;

import java.sql.Connection;
import java.sql.SQLException;

import db.ConnectionProvider;
import db.DBUtil;
import module.dao.CamperDao;
import module.model.Camper;
import module.service.DuplicateIdException;



public class JoinService {
private CamperDao camperDao = new CamperDao();
	
	public void join(JoinRequest joinReq) {
		// .......
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			Camper m = camperDao.selectById(con, joinReq.getId());
			
			if (m !=  null) {
				DBUtil.rollback(con);
				throw new DuplicateIdException();
			}
			
			Camper camper = new Camper();
			 
			camper.setId(joinReq.getId());
			camper.setName(joinReq.getName());
			camper.setGender(joinReq.getGender());			
			camper.setBirth(joinReq.getBirth());			
			
			camper.setPhone(joinReq.getPhone());
			
			camper.setEmail(joinReq.getEmail());		
			
			camper.setPassword(joinReq.getPassword());
			camper.setPassword2(joinReq.getPassword2());
			
			camperDao.insert(con, camper);
			
			con.commit();
		} catch (SQLException e) {
			DBUtil.rollback(con);
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(con);
		}
	}
}
