package camper_board.service;

import java.sql.Connection;
import java.sql.SQLException;


import db.ConnectionProvider;
import db.DBUtil;
import module.dao.Board_ContentDao;
import module.dao.Board_FreeDao;
import module.model.Board_Content;
import module.model.Board_Free;




public class WriteBoard_FreeService {
	private Board_FreeDao freeDao = new Board_FreeDao();
	private Board_ContentDao contentDao = new Board_ContentDao();
	
	public Integer write(WriteRequest req) {
		Connection con = null;
		
		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			Board_Free board_Free = toBoard_Free(req);
			Board_Free savedBoard_Free = freeDao.insert(con, board_Free);
			
			if (savedBoard_Free == null) {
				throw new RuntimeException("fail to insert board_Free");
			}
			
			Board_Content content = new Board_Content(
					savedBoard_Free.getNumber(),
					req.getContent()
					);
			
			Board_Content savedContent = contentDao.insert(con, content);
			
			if (savedContent == null) {
				throw new RuntimeException("fail to insert board_content");
			}
			
			con.commit();
			
			return savedBoard_Free.getNumber();
		} catch (SQLException e) {
			DBUtil.rollback(con);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			DBUtil.rollback(con);
			throw e;
		} finally {
			DBUtil.close(con);
		}
	}
	
	private Board_Free toBoard_Free(WriteRequest req) {
		return new Board_Free(null, req.getWriter(), req.getTitle(), null, null, 0, 0);
	}
}
