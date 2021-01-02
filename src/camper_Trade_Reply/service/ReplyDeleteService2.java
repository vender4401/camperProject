package camper_Trade_Reply.service;

import java.sql.Connection;

import java.sql.SQLException;

import db.ConnectionProvider;
import module.dao.Reply_TradeDao;


public class ReplyDeleteService2 {
	private Reply_TradeDao dao = new Reply_TradeDao();

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
