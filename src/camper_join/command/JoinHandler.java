package camper_join.command;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camper_join.service.JoinRequest;
import camper_join.service.JoinService;
import module.service.DuplicateIdException;
import mvc.command.CommandHandler;


public class JoinHandler implements CommandHandler {
	private static final String FORM_VIEW = "joinForm";
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		String phone3 = req.getParameter("phone3");
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		String email = email1 + "@" + email2;
		
		JoinRequest joinReq = new JoinRequest();
		joinReq.setId(req.getParameter("id"));
		
		joinReq.setName(req.getParameter("name"));
		joinReq.setGender(req.getParameter("gender"));
		joinReq.setBirth(req.getParameter("birth"));
		
		joinReq.setPhone(phone);
		
		joinReq.setEmail(email);
		
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setPassword2(req.getParameter("password2"));
		
		joinReq.setPasswordCheck(req.getParameter("passwordCheck"));
		
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			joinService.join(joinReq);
			return "joinSuccess";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", true);
			return FORM_VIEW;
		}

	}
}
