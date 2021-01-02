package camper_Trade_Reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import db.ConnectionProvider;
import module.dao.Reply_TradeDao;
import module.model.Reply2;

public class Reply_TradeService {
private Reply_TradeDao dao = new Reply_TradeDao();
	
	public List<Reply2> getReplyList(int board_FreeNum) {
		Connection con = ConnectionProvider.getConnection();
		
		List<Reply2> list;
		try {
			list = dao.listReply(con, board_FreeNum);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return list;
	}
}
