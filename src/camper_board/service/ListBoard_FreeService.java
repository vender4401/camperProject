package camper_board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import db.ConnectionProvider;
import module.dao.Board_FreeDao;
import module.model.Board_Free;

public class ListBoard_FreeService {
	private Board_FreeDao board_FreeDao = new Board_FreeDao();
	private int size = 10;
	
	public BoardPage getBoardPage(int pageNum) {
		try (Connection con = ConnectionProvider.getConnection()) {
			int total = board_FreeDao.selectCount(con);
			List<Board_Free> content = board_FreeDao.select(con, pageNum, size);
			
			return new BoardPage(total, pageNum, size, content);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
}
