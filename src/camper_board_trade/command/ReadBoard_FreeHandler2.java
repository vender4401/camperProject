package camper_board_trade.command;


public class ReadBoard_FreeHandler2 implements CommandHandler {
	private ReadBoard_FreeService readBoard_FreeService = new ReadBoard_FreeService();
	private ReplyService replyService = new ReplyService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int board_FreeNum = Integer.parseInt(noVal);
		try {
			Board_FreeData board_FreeData = readBoard_FreeService.getBoard_Free(board_FreeNum, true);
			req.setAttribute("board_FreeData", board_FreeData);
			
			// 자유 게시판 댓글 , Reply 의 board_FreeNum 값을 가져옴
			List<Reply> replyBoard_FreeList = replyService.getReplyList(board_FreeNum);
			req.setAttribute("replyBoard_FreeList", replyBoard_FreeList);
			
			return "readBoard_Free";
			
		} catch (Board_FreeNotFoundException | Board_ContentNotFoundException e) {
			req.getServletContext().log("no board_free", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
	}
}
