package camper_board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camper_board.service.BoardPage;
import camper_board.service.ListBoard_FreeService;
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
		
		BoardPage boardPage = listBoard_Free.getBoardPage(pageNo);
		req.setAttribute("boardPage", boardPage);
		return "listBoard_Free";
	}
}
