package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.Comment;
import mybatis.MybatisConnection;
import model.Amem;
import model.Auction;

public class BoardMybatisDao {

	public Connection getConnection() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kic", "1111");
			return conn;
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}
	
	SqlSession sqlSession = MybatisConnection.getConnection();
	private static final String ns = "board.";
	
	public int insertBoard(Auction board) throws UnsupportedEncodingException, SQLException {
	   
		int num = sqlSession.insert(ns + "insertBoard", board);
		sqlSession.commit();
		return num;
	}


	public List<Auction> boardList(int pageInt, int limit, String boardid)
			throws UnsupportedEncodingException, SQLException {

		Map map = new HashMap();
		map.put("boardid", boardid);
		map.put("start", (pageInt - 1) * limit + 1);
		map.put("end", pageInt * limit);
		return sqlSession.selectList(ns + "boardList", map);
	}

	public int boardCount(String boardid) throws UnsupportedEncodingException, SQLException {
		return sqlSession.selectOne(ns + "boardCount", boardid);
	}

	public Auction oneBoard(int num) throws UnsupportedEncodingException, SQLException {

		return sqlSession.selectOne(ns + "oneBoard", num);
	}

	public int updateBoard(Auction board) throws UnsupportedEncodingException, SQLException {

		int num = sqlSession.update(ns + "updateBoard", board);
		sqlSession.commit();
		return num;

	}
	public int boardDelete(int num) throws UnsupportedEncodingException, SQLException {

		int num2 = sqlSession.update(ns + "boardDelete", num);
		sqlSession.commit();
		return num2;

	}

	public int insertComment(String comment, int num) throws UnsupportedEncodingException, SQLException {
		
		Map map = new HashMap();
		map.put("comment", comment);
		map.put("num", num);

		int num1 = sqlSession.insert(ns+"insertComment", map);
	
		sqlSession.commit();
		return num1;

	}

	public List<Comment> commentList(int num) throws UnsupportedEncodingException, SQLException {

		return sqlSession.selectList(ns + "commentList", num);
	}
}
