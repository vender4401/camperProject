package camper_board_trade.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camper_board_trade.service.WriteBoard_FreeService2;
import camper_board_trade.service.WriteRequest2;
import camper_user.service.User;
import module.model.Trader;
import mvc.command.CommandHandler;

public class WriteBoard_FreeHandler2 implements CommandHandler {
	
	private static final String FORM_VIEW = "newTradeForm";
	private WriteBoard_FreeService2 writeBoard_FreeService = new WriteBoard_FreeService2();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errorsTrade", errors);
		
		User user = (User) req.getSession().getAttribute("authUser");
		WriteRequest2 writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newBoard_FreeNo = writeBoard_FreeService.write(writeReq);
		req.setAttribute("newTraderNo", newBoard_FreeNo);
		
		return "newTradeSuccess";
	}
	
	private WriteRequest2 createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest2(new Trader(user.getId(), user.getName()), 
				req.getParameter("title"), req.getParameter("content"),
				req.getParameter("price"), req.getParameter("place"),
				req.getParameter("timeuse")
				);
	}
}
