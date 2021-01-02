package camper_board_trade.service;

import module.dao.Board_ContentDao2;
import module.dao.Board_FreeDao2;

public class ReadBoard_FreeService2 {
	private Board_FreeDao2 board_FreeDao = new Board_FreeDao2();
	private Board_ContentDao2 board_contentDao = new Board_ContentDao2();
	
	public Board_FreeData2 getBoard_Free(int board_freeNum, boolean increaseReadCount) {
		try(Connection con = ConnectionProvider.getConnection()){
			Board_Free board_Free = board_FreeDao.selectById(con, board_freeNum);
			if(board_Free == null) {
				throw new Board_FreeNotFoundException2();
			}
			Board_Content content = board_contentDao.selectById(con, board_freeNum);
			if(content == null) {
				throw new Board_ContentNotFoundException2();
			}
			if(increaseReadCount) {
				board_FreeDao.increaseReadCount(con, board_freeNum);
			}
			return new Board_FreeData2(board_Free, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
