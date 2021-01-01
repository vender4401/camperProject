package camper_user.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camper_join.service.InvalidPasswordException;
import camper_join.service.MemberNotFoundException;
import camper_user.service.CamperModifyService;
import camper_user.service.User;
import mvc.command.CommandHandler;

public class CamperModifyHandler implements CommandHandler {
	private static final String FORM_VIEW = "camperModifyForm";
	private CamperModifyService camperModifyService = new CamperModifyService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
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
	public String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		User user = (User)req.getSession().getAttribute("authUser");
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		// form 에서 받아올 파라미터
		String curPwd = req.getParameter("curPwd");
		String newName = req.getParameter("newName");
		
		
		// form 에서 받아온 파라미터의 값 = 변수의 값의 체크 만약 true 라면
		// errors의 "curPwd"이라는 Map객체로 추가됨 
		if (curPwd == null || curPwd.isEmpty()) {			
			errors.put("curPwd", Boolean.TRUE);
		}
		if (newName == null || newName.isEmpty()) {
			errors.put("newName", Boolean.TRUE);
		}
		
		// 
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			camperModifyService.changeCamper(user.getId(), curPwd, newName);
			return "/camperModifySuccess";
		} catch (InvalidPasswordException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		}  catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
	}
}
