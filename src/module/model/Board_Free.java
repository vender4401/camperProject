package module.model;

import java.util.Date;

public class Board_Free {
	private Integer number;
	private Writer writer;
	private String title;
	private Date regdate;
	private Date moddate;
	private int readCount;
	private int recommendCount;
	
	public Board_Free(Integer number, Writer writer, String title, Date regdate, 
			Date moddate, int readCount, int recommendCount) {
		super();
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readCount = readCount;
		this.recommendCount = recommendCount;
	}

	public Integer getNumber() {
		return number;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegdate() {
		return regdate;
	}

	public Date getModdate() {
		return moddate;
	}

	public int getReadCount() {
		return readCount;
	}

	public int getRecommendCount() {
		return recommendCount;
	}
	
	
	
}
