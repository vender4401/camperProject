package camper_Trade_Reply.service;

import java.sql.Connection;

import java.sql.SQLException;

import db.ConnectionProvider;

import module.dao.Reply_TradeDao;

public class ReplyAddService2 {
	private Reply_TradeDao dao = new Reply_TradeDao();

	public void add(String userId, String userName, int boardNo, String body) {
		Connection con = ConnectionProvider.getConnection();		
		try {
			dao.insert(con, userId, userName, boardNo, body);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}


}
