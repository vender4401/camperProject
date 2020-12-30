package camper_board.service;

import java.util.Map;

public class ModifyRequest {
	private String userId;
	private int board_FreeNumber;
	private String title;
	private String content;	
	
	public ModifyRequest(String userId, int board_FreeNumber, String title, String content) {
		super();
		this.userId = userId;
		this.board_FreeNumber = board_FreeNumber;
		this.title = title;
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public int getBoard_FreeNumber() {
		return board_FreeNumber;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	
	public void validate(Map<String, Boolean> errors) {
		if(title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}
}
