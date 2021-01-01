package camper_board.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import camper_board.service.BoardPage;
import camper_board.service.ListBoard_FreeService;
import camper_board.service.ReplyPage;
import mvc.command.CommandHandler;


public class ListBoard_FreeHandler implements CommandHandler {
private ListBoard_FreeService listBoard_Free = new ListBoard_FreeService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		ReplyPage replyPage = listBoard_Free.getBoardPage(pageNo);
		req.setAttribute("boardPage", replyPage);
		return "listBoard_Free";
	}
}
