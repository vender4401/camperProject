package camper_user.command;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import mvc.command.CommandHandler;

public class UserInfoHandler implements CommandHandler {
	private static final String FORM_VIEW = "userInfo";

	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
			return FORM_VIEW;

		
	}


	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
}
