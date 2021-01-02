package camper_board_trade.service;

import module.model.Board_Content2;
import module.model.Board_Free2;

public class Board_FreeData2 {
	private Board_Free2 board_Free;
	private Board_Content2 board_Content;
	
	public Board_FreeData2(Board_Free2 board_Free, Board_Content2 board_Content) {
		this.board_Free = board_Free;
		this.board_Content = board_Content;
	}
	
	public Board_Free2 getBoard_Free() {
		return board_Free;
	}
	
	public String getBoard_Content() {
		return board_Content.getContent();
	}
}
