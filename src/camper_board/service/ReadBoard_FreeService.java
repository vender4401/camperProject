package camper_board.service;

import java.sql.Connection;
import java.sql.SQLException;

import db.ConnectionProvider;
import module.dao.Board_ContentDao;
import module.dao.Board_FreeDao;
import module.model.Board_Content;
import module.model.Board_Free;


public class ReadBoard_FreeService {
	private Board_FreeDao board_FreeDao = new Board_FreeDao();
	private Board_ContentDao board_contentDao = new Board_ContentDao();
	
	public Board_FreeData getBoard_Free(int board_freeNum, boolean increaseReadCount) {
		try(Connection con = ConnectionProvider.getConnection()){
			Board_Free board_Free = board_FreeDao.selectById(con, board_freeNum);
			if(board_Free == null) {
				throw new Board_FreeNotFoundException();
			}
			Board_Content content = board_contentDao.selectById(con, board_freeNum);
			if(content == null) {
				throw new Board_ContentNotFoundException();
			}
			if(increaseReadCount) {
				board_FreeDao.increaseReadCount(con, board_freeNum);
			}
			return new Board_FreeData(board_Free, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
