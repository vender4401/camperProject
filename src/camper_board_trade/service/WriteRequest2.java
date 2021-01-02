package camper_board_trade.service;

import java.util.Map;

import module.model.Trader;

public class WriteRequest2 {
	private Trader trader;
	private String title;
	private String content;
	private String price;
	private String place;
	private String timeuse;
	
	
	
	public WriteRequest2(Trader trader, String title, String content, String price, String place, String timeuse) {
		super();
		this.trader = trader;
		this.title = title;
		this.content = content;
		this.price = price;
		this.place = place;
		this.timeuse = timeuse;
	}
	public Trader getTrader() {
		return trader;
	}
	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
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
	public void validate(Map<String, Boolean> errors) {
		if(title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
		if(content == null || content.trim().isEmpty()) {
			errors.put("content", Boolean.TRUE);
		}
	}

	
}
