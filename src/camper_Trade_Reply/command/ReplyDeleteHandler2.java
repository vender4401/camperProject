package camper_Trade_Reply.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import camper_Trade_Reply.service.ReplyDeleteService2;

import camper_user.service.User;
import mvc.command.CommandHandler;

public class ReplyDeleteHandler2 implements CommandHandler {
private ReplyDeleteService2 deleteService = new ReplyDeleteService2();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("authUser");
		
		int replyId = Integer.parseInt(req.getParameter("id"));
		String no = req.getParameter("no");
						
		String pageNo = req.getParameter("pageNo");
		deleteService.delete(replyId);
		res.sendRedirect(req.getContextPath() + 
				"/trade/read.do?no=" + no + "&pageNo=" + pageNo);

		return null;
	}
}
