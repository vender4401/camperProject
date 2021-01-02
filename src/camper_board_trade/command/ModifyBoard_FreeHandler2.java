package camper_board_trade.command;



public class ModifyBoard_FreeHandler2 implements CommandHandler {
	
	private static final String FORM_VIEW = "modifyBoard_FreeForm";

	private ReadBoard_FreeService readService = new ReadBoard_FreeService();
	private ModifyBoard_FreeService modifyService = new ModifyBoard_FreeService();

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
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			
			Board_FreeData board_FreeData = readService.getBoard_Free(no, false);
			User authUser = (User) req.getSession().getAttribute("authUser");
			if (!canModify(authUser, board_FreeData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			
			ModifyRequest modreq = new ModifyRequest(
					authUser.getId(),no, 
					board_FreeData.getBoard_Free().getTitle(),
					board_FreeData.getBoard_Content());			
			
			req.setAttribute("modReq", modreq);
			return FORM_VIEW;
			
		} catch (Board_FreeNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		User authUser = (User) req.getSession().getAttribute("authUser");
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		
		ModifyRequest modReq = new ModifyRequest(
				authUser.getId(),no,
				req.getParameter("title"),
				req.getParameter("content"));
		req.setAttribute("modReq", modReq);
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		modReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		
		try {
			modifyService.modify(modReq);
			return "modifyBoard_FreeSuccess";
		} catch (Board_FreeNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
			/*
			 * // 익셉션이 발생하면 응? // errors의 "noWriter" 라는 이름으로 들어감
			 * 
			 * errors.put("noWriter", true); // req의 errors 라는 이름으로 지정
			 * req.setAttribute("errors", errors); return FORM_VIEW;
			 */			
		}
	}

			
	private boolean canModify(User authUser, Board_FreeData board_FreeDate) {
		String writerId = board_FreeDate.getBoard_Free().getWriter().getId();
		return authUser.getId().equals(writerId);
	}

}
