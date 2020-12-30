package camper_board.command;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camper_board.service.Board_ContentNotFoundException;
import camper_board.service.Board_FreeData;
import camper_board.service.Board_FreeNotFoundException;
import camper_board.service.ReadBoard_FreeService;
import camper_reply.service.ReplyService;
import module.model.Reply;
import mvc.command.CommandHandler;


public class ReadBoard_FreeHandler implements CommandHandler {
	private ReadBoard_FreeService readBoard_FreeService = new ReadBoard_FreeService();
	private ReplyService replyService = new ReplyService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int board_FreeNum = Integer.parseInt(noVal);
		try {
			Board_FreeData board_FreeData = readBoard_FreeService.getBoard_Free(board_FreeNum, true);
			req.setAttribute("board_FreeData", board_FreeData);
			
			List<Reply> replyList = replyService.getReplyList(board_FreeNum);
			req.setAttribute("replyList", replyList);
			
			return "readBoard_Free";
			
		} catch (Board_FreeNotFoundException | Board_ContentNotFoundException e) {
			req.getServletContext().log("no board_free", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
	}
}
