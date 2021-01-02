package camper_board_trade.service;

import java.sql.Connection;

import java.sql.SQLException;

import db.ConnectionProvider;
import db.DBUtil;
import module.dao.Board_ContentDao2;
import module.dao.Board_FreeDao2;
import module.model.Board_Content2;
import module.model.Board_Free2;

public class WriteBoard_FreeService2 {
	private Board_FreeDao2 freeDao = new Board_FreeDao2();
	private Board_ContentDao2 contentDao = new Board_ContentDao2();
	
	public Integer write(WriteRequest2 req) {
		Connection con = null;
		
		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			Board_Free2 board_Free = toBoard_Free(req);
			Board_Free2 savedBoard_Free = freeDao.insert(con, board_Free);
			
			if (savedBoard_Free == null) {
				throw new RuntimeException("fail to insert board_Free");
			}
			
			Board_Content2 content = new Board_Content2(
					savedBoard_Free.getNumber(),
					req.getContent()
					);
			
			Board_Content2 savedContent = contentDao.insert(con, content);
			
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
	
	private Board_Free2 toBoard_Free(WriteRequest2 req) {
		return new Board_Free2(null, req.getTrader(), req.getTitle(),
				req.getPrice(), req.getPlace(), req.getTimeuse(), 
				null, null, 0);
	}
}
