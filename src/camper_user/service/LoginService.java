package camper_user.service;

import java.sql.Connection;

import java.sql.SQLException;

import db.ConnectionProvider;
import module.dao.CamperDao;
import module.model.Camper;

public class LoginService {
	private CamperDao camperDao = new CamperDao();
	
	public User login(String id, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Camper camper = camperDao.selectById(conn, id);
			if (camper == null) {
				throw new LoginFailException();
			}
			if (!camper.matchPassword(password)) {
				throw new LoginFailException();
			}
			
			return new User(camper.getId(), camper.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
