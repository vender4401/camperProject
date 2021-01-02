package camper_board_trade.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import camper_board.service.PermissionDeniedException;
import camper_board_trade.service.Board_FreeData2;
import camper_board_trade.service.DeleteBoard_FreeService2;
import camper_board_trade.service.ReadBoard_FreeService2;
import camper_user.service.User;
import mvc.command.CommandHandler;

public class DeleteBoard_FreeHandler2 implements CommandHandler {
private static final String FORM_VIEW = "deleteBoard_FreeForm";
	
	private ReadBoard_FreeService2 readService = new ReadBoard_FreeService2();
	private DeleteBoard_FreeService2 deleteBoard_FreeService = new DeleteBoard_FreeService2();

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		// 현재 로그인 한 사용자
		// 삭제하려는 게시물의 작성자
		HttpSession session = req.getSession();
		User authUser = (User) session.getAttribute("authUser");
		
		int no = Integer.parseInt(req.getParameter("no"));
		String password = req.getParameter("password");
		
		Board_FreeData2 board_FreeData = readService.getBoard_Free(no, false);
		
		// 가 같으면 삭제함
		//    암호가 일치하는 지 확인 해서
		//           일치하면 삭제
		//           아니면 throw exception
		
		// 안 같으면 throw exception
		if (!authUser.getId().equals(board_FreeData.getBoard_Free().getTrader().getId())) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		try {
			deleteBoard_FreeService.delete(no, authUser, password);
			
		} catch (PermissionDeniedException e) {
			errors.put("invalidePassword", true);
			return FORM_VIEW;
		}	catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return "deleteBoard_FreeSuccess";
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		
		return FORM_VIEW;
	}
}
