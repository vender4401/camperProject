package camper_board.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camper_board.service.WriteBoard_FreeService;
import camper_board.service.WriteRequest;
import camper_user.service.User;
import module.model.Writer;
import mvc.command.CommandHandler;



public class WriteBoard_FreeHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "newBoard_FreeForm";
	private WriteBoard_FreeService writeBoard_FreeService = new WriteBoard_FreeService();
	
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
		req.setAttribute("errors", errors);
		
		User user = (User) req.getSession().getAttribute("authUser");
		WriteRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newBoard_FreeNo = writeBoard_FreeService.write(writeReq);
		req.setAttribute("newBoard_FreeNo", newBoard_FreeNo);
		
		return "newBoard_FreeSuccess";
	}
	
	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(new Writer(user.getId(), user.getName()), req.getParameter("title"), req.getParameter("content"));
	}
}
