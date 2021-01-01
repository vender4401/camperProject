package camper_reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import db.ConnectionProvider;
import module.dao.Reply_FreeDao;

public class ReplyDeleteService {
	private Reply_FreeDao dao = new Reply_FreeDao();

	public void delete(Integer replyId) {
		Connection con = ConnectionProvider.getConnection();		
		try {
			dao.delete(con, replyId);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}	
}
