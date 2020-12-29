package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import db.ConnectionProvider;
import module.dao.Reply_FreeDao;


public class ReplyAddService {
	private Reply_FreeDao dao = new Reply_FreeDao();

	public void add(String userId, int boardNo, String body) {
		Connection con = ConnectionProvider.getConnection();		
		try {
			dao.insert(con, userId, boardNo, body);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}	
}
