package module.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import module.model.Reply;
import module.model.Reply2;

public class Reply_TradeDao {
	public void delete(Connection con, Integer id) throws SQLException {
		String sql = "DELETE reply_free WHERE replyid=?";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
		}
	}
	
	
	public void insert(Connection con, String camperId, String writerId, int boardNo, String body) throws SQLException {
		String sql = "INSERT INTO reply_free "
				+ "(camperid, writerid, board_no, body, regdate) "
				+ "VALUES (?, ?, ?, ?, SYSDATE)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, camperId);
			pstmt.setString(2, writerId);
			pstmt.setInt(3, boardNo);
			pstmt.setString(4, body);
			
			pstmt.executeUpdate();
		}
		
	}

	public List<Reply2> listReply(Connection con, int boardNum) throws SQLException {
		String sql = "SELECT replyid, camperid, writerid, board_no, body, regdate "
				+ "    FROM reply_trade "
				+ "    WHERE board_no=? "
				+ "    ORDER BY replyid DESC";
		
		List<Reply2> list = new ArrayList<>();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, boardNum);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reply2 r = new Reply2();
				r.setId(rs.getInt(1));
				r.setCamperId(rs.getString(2));
				r.setWriterId(rs.getString(3));
				r.setBoard_FreeNum(rs.getInt(4));
				r.setBody(rs.getString(5));
				r.setRegDate(rs.getTimestamp(6));
				
				list.add(r);
			}
			
		}
		return list;
	}
}
