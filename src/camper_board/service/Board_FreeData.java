package camper_board.service;

import module.model.Board_Content;
import module.model.Board_Free;

public class Board_FreeData {
	private Board_Free board_Free;
	private Board_Content board_Content;
	
	public Board_FreeData(Board_Free board_Free, Board_Content board_Content) {
		this.board_Free = board_Free;
		this.board_Content = board_Content;
	}
	
	public Board_Free getBoard_Free() {
		return board_Free;
	}
	
	public String getBoard_Content() {
		return board_Content.getContent();
	}
}
