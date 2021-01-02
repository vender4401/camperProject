package camper_board_trade.service;



public class DeleteBoard_FreeService2 {
	private CamperDao camperDao = new CamperDao();
	private Board_FreeDao board_FreeDao = new Board_FreeDao();
	private Board_ContentDao board_ContentDao = new Board_ContentDao();

	public void delete(int no, User authUser, String password) {

		Connection con = ConnectionProvider.getConnection();
		try {
			con.setAutoCommit(false);
			Camper camper = camperDao.selectById(con, authUser.getId());
			
			// 같지 않으면 throw exception
			if (!camper.getPassword().equals(password)) {
				throw new PermissionDeniedException2();
			}
			
			// password와 사용자의 비번이 같으면
			//   articleDao.delete, articleContentDao.delete
			board_FreeDao.delete(con, no);
			board_ContentDao.delete(con, no);
			con.commit();
		} catch (SQLException e) {
			DBUtil.rollback(con);
			throw new RuntimeException(e);
		}
		
	}
}
