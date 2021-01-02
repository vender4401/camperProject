package camper_board_trade.service;



public class BoardPage2 {
	private int total; // 전체 게시물 수
	private int currentPage; //현재 페이지
	private List<Board_Free> content; // select한 데이터 들
	private int totalPages; // 총 페이지 수
	private int startPage; // 시작 페이지
	private int endPage; // 마지막 페이지
	
	public BoardPage2(int total, int currentPage,
		int size, List<Board_Free> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if (total != 0) {
			this.totalPages = total / size;
			if (total % size > 0) {
				this.totalPages++;
			}
			
			this.startPage = (currentPage - 1) / 5 * 5 + 1;
			this.endPage = Math.min(startPage + 4, totalPages);
		}
	}
	
	public int getTotal() {
		return total;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public List<Board_Free> getContent() {
		return content;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public boolean hasBoards() {
		return total > 0;
	}
	
	public boolean hasNoBoards() {
		return total == 0;
	}
}
