package camper_user.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import camper_join.service.InvalidPasswordException;
import camper_join.service.MemberNotFoundException;
import camper_user.service.RemoveCamperService;
import camper_user.service.User;
import mvc.command.CommandHandler;


public class RemoveCamperHandler implements CommandHandler{
	private static final String FORM_VIEW = "removeForm";
	private RemoveCamperService removeCamperService = new RemoveCamperService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 이전의 handler 메소드 내용 참조
		
		// get 요청이면 processForm 메소드 실행
		if(req.getMethod().equalsIgnoreCase("get")) {
			return processForm(req, res);
		// post 요청이면 processSubmit 메소드 실행
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(req, res);
		// 아니면 에러 응답
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		// ** 이전 handler processForm 메소드 참조
		// view 의 이름을 리턴
		return FORM_VIEW;
	}
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// password 파라미터를 얻기
		String password = req.getParameter("password");	
		String password2 = req.getParameter("password2");	
		// - errors 맵을 만들어서
		// - request attribute에 넣고 
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		// password가 null 이거나 비어 있으면(empty)
		// -errors에 (코드와 true (키, 밸류 쌍)) 넣기 - (벨류의값이 boolean)
				
		if (password == null || password.isEmpty()) {			
			errors.put("password", Boolean.TRUE);
		}
		if (password2 == null || password2.isEmpty()) {			
			errors.put("password2", Boolean.TRUE);
		}	
		// view 의 이름을 리턴
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		// 세션에서 user 객체 얻기(authUser attribute)
		User user = (User)req.getSession().getAttribute("authUser");
		
		// 서비스에게 일 시키기
		
		
		try {			
			removeCamperService.removeMember(user, password, password2);
			// 세션을 invalidate ();
			req.getSession().invalidate();			
			return "removeMemberSuccess";			
			// 문제가 생기면 (문제1. 사용자가 없는 경우)
		} catch (InvalidPasswordException e) { // catch 문 2개 (각 문제마다)
			errors.put("idOrPwNotMatch", true);			
			return FORM_VIEW;
			//			(문제2. 패스워드가 틀린 경우)
			// - errors 맵에 코드 추가
			// 폼으로 forward하도록 view이름 리턴
			
		}

		
		catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
	}
}
