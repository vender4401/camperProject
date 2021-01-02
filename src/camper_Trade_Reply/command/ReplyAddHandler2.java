package camper_Trade_Reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import camper_Trade_Reply.service.ReplyAddService2;
import camper_board.service.ReadBoard_FreeService;
import camper_reply.service.ReplyAddService;
import camper_user.service.User;
import mvc.command.CommandHandler;


public class ReplyAddHandler2 implements CommandHandler {
	private ReplyAddService2 addService = new ReplyAddService2();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("authUser");
		
		int boardNo = Integer.parseInt(req.getParameter("no"));
		String userId = user.getId();
		String userName = user.getName();
		
		String body = req.getParameter("body");
		String pageNo = req.getParameter("pageNo");
				
		addService.add(userId, userName, boardNo, body);
		res.sendRedirect(req.getContextPath() + 
				"/trade/read.do?no=" + boardNo + "&pageNo=" + pageNo);

		return null;
	}
}
