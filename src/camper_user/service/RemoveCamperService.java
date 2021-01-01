package camper_user.service;

import java.sql.Connection;

import java.sql.SQLException;

import camper_join.service.InvalidPasswordException;
import camper_join.service.MemberNotFoundException;
import db.ConnectionProvider;
import db.DBUtil;
import module.dao.CamperDao;
import module.model.Camper;


public class RemoveCamperService {
private CamperDao camperDao = new CamperDao();
	
	public void removeMember(User user, String password, String password2) {
		
		// 0. 커넥션 얻기
		Connection con = null;
		// 1. dao 의 selectById로 member 객체 얻기
		// 	  1.1 member없으면 MemberNotFoundException 발생
		
		// 2. password와 camper.password가 같은지 확인
		//    2.1 다르면 InvalidPasswordException 발생
		
		// 3. delete() 메소드 실행
		 try {
	         con = ConnectionProvider.getConnection();
	         con.setAutoCommit(false);
	         Camper camper = camperDao.selectById(con, user.getId());
	         if (camper == null) {
	            throw new MemberNotFoundException();
	         }
	         if (!camper.matchPassword(password)) {
	            throw new InvalidPasswordException();
	         }
	         if (!camper.matchPassword2(password2)) {
		        throw new InvalidPasswordException();
		     }
	         camperDao.delete(con, user.getId());
	         con.commit();
	      } catch (SQLException e) {
	         DBUtil.rollback(con);
	         throw new RuntimeException(e);
	      } finally {
	         DBUtil.close(con);
	      }

	}
}
