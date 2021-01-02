package camper_board_trade.service;



public class ModifyBoard_FreeService2 {
	private Board_FreeDao board_FreeDao = new Board_FreeDao();
	private Board_ContentDao contentDao = new Board_ContentDao();
	
	public void modify(ModifyRequest2 modReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Board_Free board_Free = board_FreeDao.selectById(conn, modReq.getBoard_FreeNumber());
			if(board_Free == null) {
				throw new Board_FreeNotFoundException2();
			}
			if(!canModify(modReq.getUserId(), board_Free)) {
				throw new PermissionDeniedException2();
			}
			board_FreeDao.update(conn,modReq.getBoard_FreeNumber(), modReq.getTitle());
			contentDao.update(conn,modReq.getBoard_FreeNumber(), modReq.getContent());
			conn.commit();
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException2 e) {
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
