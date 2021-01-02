package camper_board_trade.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camper_board_trade.service.ListBoard_FreeService2;
import camper_board_trade.service.ReplyPage2;
import mvc.command.CommandHandler;

public class ListBoard_FreeHandler2 implements CommandHandler {
private ListBoard_FreeService2 listBoard_Free = new ListBoard_FreeService2();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		ReplyPage2 replyPage = listBoard_Free.getBoardPage(pageNo);
		req.setAttribute("boardPage", replyPage);
		return "listBoard_Free";
	}
}
