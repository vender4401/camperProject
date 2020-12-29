package reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import db.ConnectionProvider;
import module.dao.Reply_FreeDao;
import module.model.Reply;


public class ReplyService {
private Reply_FreeDao dao = new Reply_FreeDao();
	
	public List<Reply> getReplyList(int boardNum) {
		Connection con = ConnectionProvider.getConnection();
		
		List<Reply> list;
		try {
			list = dao.listReply(con, boardNum);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return list;
	}
}
