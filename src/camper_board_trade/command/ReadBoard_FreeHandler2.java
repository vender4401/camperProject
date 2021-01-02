package camper_board_trade.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camper_Trade_Reply.service.ReplyService2;
import camper_board.service.Board_ContentNotFoundException;
import camper_board.service.Board_FreeNotFoundException;
import camper_board_trade.service.Board_FreeData2;
import camper_board_trade.service.ReadBoard_FreeService2;

import module.model.Reply2;
import mvc.command.CommandHandler;

public class ReadBoard_FreeHandler2 implements CommandHandler {
	private ReadBoard_FreeService2 readBoard_FreeService = new ReadBoard_FreeService2();
	private ReplyService2 replyService = new ReplyService2();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int board_FreeNum = Integer.parseInt(noVal);
		try {
			Board_FreeData2 board_FreeData = readBoard_FreeService.getBoard_Free(board_FreeNum, true);
			req.setAttribute("tradeData", board_FreeData);
			
			// 자유 게시판 댓글 , Reply 의 board_FreeNum 값을 가져옴
			List<Reply2> replyBoard_FreeList = replyService.getReplyList(board_FreeNum);
			req.setAttribute("replyTrade_List", replyBoard_FreeList);
			
			return "readTrade";
			
		} catch (Board_FreeNotFoundException | Board_ContentNotFoundException e) {
			req.getServletContext().log("no board_free", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
	}
}
