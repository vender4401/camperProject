package camper_board_trade.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import db.ConnectionProvider;
import module.dao.Board_FreeDao2;
import module.model.Reply_Free2;


public class ListBoard_FreeService2 {
	private Board_FreeDao2 board_FreeDao = new Board_FreeDao2();
	private int size = 10;
	
	public ReplyPage2 getBoardPage(int pageNum) {
		try (Connection con = ConnectionProvider.getConnection()) {
			int total = board_FreeDao.selectCount(con);

			List<Reply_Free2> content = board_FreeDao.select(con, pageNum, size);
			
			return new ReplyPage2(total, pageNum, size, content);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
}
