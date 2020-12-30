package camper_reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import camper_reply.service.ReplyAddService;
import camper_user.service.User;
import mvc.command.CommandHandler;


public class ReplyAddHandler implements CommandHandler {
private ReplyAddService addService = new ReplyAddService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("authUser");
		
		int boardNo = Integer.parseInt(req.getParameter("no"));
		String userId = user.getId();
		String body = req.getParameter("body");
		
		addService.add(userId, boardNo, body);
		
		return "replyAddSuccess";
	}
}
