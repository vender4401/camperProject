package camper_board.service;

import java.sql.Connection;
import java.sql.SQLException;

import db.ConnectionProvider;
import db.DBUtil;
import module.dao.Board_ContentDao;
import module.dao.Board_FreeDao;
import module.model.Board_Free;

public class ModifyBoard_FreeService {
	private Board_FreeDao board_FreeDao = new Board_FreeDao();
	private Board_ContentDao contentDao = new Board_ContentDao();
	
	public void modify(ModifyRequest modReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Board_Free board_Free = board_FreeDao.selectById(conn, modReq.getBoard_FreeNumber());
			if(board_Free == null) {
				throw new Board_FreeNotFoundException();
			}
			if(!canModify(modReq.getUserId(), board_Free)) {
				throw new PermissionDeniedException();
			}
			board_FreeDao.update(conn,modReq.getBoard_FreeNumber(), modReq.getTitle());
			contentDao.update(conn,modReq.getBoard_FreeNumber(), modReq.getContent());
			conn.commit();
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			DBUtil.rollback(conn);
			throw e;
		} finally {
			DBUtil.close(conn);
		}
		
	} 
	private boolean canModify(String modfyingUserId, Board_Free board_Free) {
		return board_Free.getWriter().getId().equals(modfyingUserId);
	}
}
