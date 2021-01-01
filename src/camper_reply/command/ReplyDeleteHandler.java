package camper_reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import camper_reply.service.ReplyDeleteService;
import camper_user.service.User;
import mvc.command.CommandHandler;

public class ReplyDeleteHandler implements CommandHandler {
private ReplyDeleteService deleteService = new ReplyDeleteService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("authUser");
		
		int replyId = Integer.parseInt(req.getParameter("id"));
		String no = req.getParameter("no");
						
		String pageNo = req.getParameter("pageNo");
		deleteService.delete(replyId);
		res.sendRedirect(req.getContextPath() + 
				"/board_Free/read.do?no=" + no + "&pageNo=" + pageNo);
		
		return null;
	}
}
