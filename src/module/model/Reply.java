package module.model;

import java.util.Date;

public class Reply {
	private int id;
	private String memberId;
	private int board_FreeNum;
	private String body;
	private Date regDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public int getBoard_FreeNum() {
		return board_FreeNum;
	}
	public void setBoard_FreeNum(int board_FreeNum) {
		this.board_FreeNum = board_FreeNum;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}	
}
