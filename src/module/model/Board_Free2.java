package module.model;

import java.util.Date;

public class Board_Free2 {
	private Integer Number;
	private Trader trader;
	private String title;
	private String price;
	private String place;
	private String timeuse;
	
	private Date regdate;
	private Date moddate;
	private int readCount;
	
	
	public Board_Free2(Integer number, Trader trader, String title, String price, String place, String timeuse,
			Date regdate, Date moddate, int readCount) {
		super();
		Number = number;
		this.trader = trader;
		this.title = title;
		this.price = price;
		this.place = place;
		this.timeuse = timeuse;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readCount = readCount;
	}
	
	
	public Integer getNumber() {
		return Number;
	}
	

	public Trader getTrader() {
		return trader;
	}
	public String getTitle() {
		return title;
	}
	public String getPrice() {
		return price;
	}
	public String getPlace() {
		return place;
	}
	public String getTimeuse() {
		return timeuse;
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
	
	
	
	
	
	
	
	
	
	

}
