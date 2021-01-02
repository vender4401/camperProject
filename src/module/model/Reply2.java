package module.model;

import java.util.Date;

public class Reply2 {
	private Integer id;
	private String camperId;
	private int board_FreeNum;
	private String body;
	private Date regDate;
	private String writerId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
		
	public String getCamperId() {
		return camperId;
	}
	public void setCamperId(String camperId) {
		this.camperId = camperId;
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
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	
}
