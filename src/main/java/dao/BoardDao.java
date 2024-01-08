package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Board;
import model.Comment;
import model.Amem;

public class BoardDao {

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
	 
	 public int insertBoard(Board board) throws UnsupportedEncodingException, SQLException {
	      	
	      Connection conn = getConnection();
	          
	         PreparedStatement pstmt = conn.prepareStatement("insert into board "
	        		  + "values (boardseq.nextval,?,?,?,?,?,sysdate,0,?)");
	         //mapping
	         pstmt.setString(1,board.getName());
	         pstmt.setString(2,board.getPass());
	         pstmt.setString(3,board.getSubject());
	         pstmt.setString(4,board.getContent());
	         pstmt.setString(5,board.getFile1());
	         pstmt.setString(6,board.getBoardid());
	         
	         //4)excute
	         int num = pstmt.executeUpdate();
	         return num;
	                  
	   }
	 
	 public List<Board> boardList(int pageInt, int limit, String boardid) throws UnsupportedEncodingException, SQLException {
		 
		 Connection conn = getConnection();
         String sql = " select * from( "
         		+ " select rownum rnum, a.* from ( "
         		+ " select * from board where boardid = ? "
         		+ " order by num desc) a) "
         		+ " where rnum between ? and ? ";
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, boardid);// 분류
         pstmt.setInt(2, (pageInt-1)*limit+1);// start  
         pstmt.setInt(3, (pageInt*limit));// end    
         
		ResultSet rs = pstmt.executeQuery();
		List<Board> li = new ArrayList<>();
		while(rs.next()) {
			Board m = new Board();
			m.setNum(rs.getInt("num"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setSubject(rs.getString("subject"));
			m.setContent(rs.getString("content"));
			m.setFile1(rs.getString("file1"));
			m.setRegdate(rs.getDate("regdate"));
			m.setReadcnt(rs.getInt("readcnt"));
			m.setBoardid(rs.getString("boardid"));
			
			li.add(m);
		}
		return li;
	 }
public int boardCount(String boardid) throws UnsupportedEncodingException, SQLException {
		 
		 Connection conn = getConnection();       
         PreparedStatement pstmt = conn.prepareStatement("select nvl (count(*),0) from board where boardid = ?");
         pstmt.setString(1, boardid);
 		 ResultSet rs = pstmt.executeQuery();
 		 if(rs.next()) {
 			 return rs.getInt(1);
 		 }
           return 0;
}
	 public Board oneBoard(int num) throws UnsupportedEncodingException, SQLException {
		 
        Connection conn = getConnection();         
        PreparedStatement pstmt = conn.prepareStatement("select * from board where num = ?");				
		pstmt.setInt(1, num);
		ResultSet rs = pstmt.executeQuery();
		Board m = new Board();
		
		if(rs.next()) {			
			m.setNum(rs.getInt("num"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setSubject(rs.getString("subject"));
			m.setContent(rs.getString("content"));
			m.setFile1(rs.getString("file1"));
			m.setRegdate(rs.getDate("regdate"));
			m.setReadcnt(rs.getInt("readcnt"));
			m.setBoardid(rs.getString("boardid"));
	 }
		return m;
}
	 
	  public int updateBoard(Board board) throws UnsupportedEncodingException, SQLException {
	      	
	      Connection conn = getConnection();        
	         String sql = 
	         "update board set name=?,subject=?,content=?,file1=?" + "where num =?";
	          PreparedStatement pstmt = conn.prepareStatement(sql);
	         //mapping
             pstmt.setString(1,board.getName());
             pstmt.setString(2,board.getSubject());
             pstmt.setString(3,board.getContent());
             pstmt.setString(4,board.getFile1());             
             pstmt.setInt(5,board.getNum());
             //4)excute
             int num = pstmt.executeUpdate();
             return num;
	                  
	   }
	  
	  public int boardDelete(int num) throws UnsupportedEncodingException, SQLException {
        	
          Connection con = getConnection();
          PreparedStatement pstmt = null;
          String sql = "delete from board where num =?";    
          pstmt = con.prepareStatement( sql );
          pstmt.setInt(1,num);
          return pstmt.executeUpdate();
                      
       }
	  
	  public int insertComment(String comment, int num) throws UnsupportedEncodingException, SQLException {
        	
          Connection con = getConnection();
          PreparedStatement pstmt = null;
          String sql = "insert into boardcomment values (boardcomseq.nextval,?,?,sysdate)";    
          pstmt = con.prepareStatement( sql );
          pstmt.setInt(1,num);
          pstmt.setString(2,comment);
          return pstmt.executeUpdate();
                      
       }

 public List<Comment> commentList(int num) throws UnsupportedEncodingException, SQLException {
          
          Connection conn = getConnection();
            PreparedStatement pstmt =
                  conn.prepareStatement("select * from boardcomment where num = ? order by regdate desc");
            pstmt.setInt(1, num);            
         ResultSet rs = pstmt.executeQuery();
         List<Comment> li = new ArrayList<Comment>();
         while(rs.next()) {
            Comment c = new Comment();
            c.setNum(rs.getInt("num"));
            c.setContent(rs.getString("content"));            
            li.add(c);
         }
         return li;
       }
}






















