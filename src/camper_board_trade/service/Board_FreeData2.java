package camper_board_trade.service;


public class Board_FreeData2 {
	private Board_Free board_Free;
	private Board_Content board_Content;
	
	public Board_FreeData2(Board_Free board_Free, Board_Content board_Content) {
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
