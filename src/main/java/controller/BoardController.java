package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.BoardDao;
import dao.MemberDao;
import dao.MemberMybatisDao;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Board;
import model.Comment;
import model.Amem;

@WebServlet("/board/*")
public class BoardController extends MskimRequestMapping {
   BoardDao bd = new BoardDao();
   MemberMybatisDao md = new MemberMybatisDao();
   HttpSession session;
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      this.session = request.getSession();
      super.service(request, resp);
   }
   
	
	
 

   @RequestMapping("boardForm") 
   public String boardForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
      // TODO Auto-generated method stub
      return "/WEB-INF/view/board/boardForm.jsp";
   }
   
   @RequestMapping("boardPro") 
   public String boardPro(HttpServletRequest req, HttpServletResponse res) throws Exception {
      
      String path =
            req.getServletContext().getRealPath("/")+"image/board/";
      String filename = null;
      String msg = "게시물 등록 실패";
      String url = "/board/boardForm";
      
      MultipartRequest multi = new MultipartRequest
            (req,path,10*1024*1024,"utf-8");
      Board board = new Board();
      
      String boardid = (String) session.getAttribute("boardid");
      if(boardid==null) boardid = "1";
            
      board.setBoardid(boardid);      
      board.setName(multi.getParameter("name"));
      board.setPass(multi.getParameter("pass"));
      board.setSubject(multi.getParameter("subject"));
      board.setContent(multi.getParameter("content"));
      board.setFile1(multi.getFilesystemName("file1"));  //name="file1"
      System.out.println(board);
      BoardDao bd = new BoardDao();
      int num = bd.insertBoard(board);
      if(num>0) {
         msg = "게시물 등록 성공";
         url = "/board/boardList";
      }
      req.setAttribute("msg", msg);
      req.setAttribute("url", url);
      return "/WEB-INF/view/alert.jsp";
   }
   @RequestMapping("products") 
   public String products(HttpServletRequest req, HttpServletResponse res) throws Exception {
      // TODO Auto-generated method stub
      
      //board session 처리한다.      
      if(req.getParameter("boardid")!=null) { //? boardid = 3
         session.setAttribute("boardid", req.getParameter("boardid"));}
          session.setAttribute("pageNum", "1");
      
      String boardid = (String) session.getAttribute("boardid");
      if(boardid==null) boardid = "1";
      String boardName = "";
      switch(boardid) {
      case "1":
         boardName = "가전";
         break;
      case "2":
         boardName = "의류";
         break;
      case "3":
         boardName = "기타";
         break;
  
   
      }
      
      //page 설정
      if(req.getParameter("pageNum")!=null) { 
         session.setAttribute("pageNum", req.getParameter("pageNum"));}
      
      String pageNum = (String) session.getAttribute("pageNum");
      if(pageNum == null) pageNum ="1";
      
      int limit = 3; //한페이장 게시글 갯수
      int pageInt = Integer.parseInt(pageNum); //페이지 번호
      int boardCount = bd.boardCount(boardid); //전체 개시글 갯수
      
      int boardNum = boardCount -((pageInt-1)*limit);
      
      List<Board> li = bd.boardList(pageInt,limit,boardid);
      
      //pagging
      int bottomLine =3;
      int start = (pageInt-1)/bottomLine * bottomLine +1; //1,2,3->1 ,,4,5,6->4
      int end = start + bottomLine -1;
      int maxPage = (boardCount/limit) + (boardCount % limit ==0?0:1);
      if (end > maxPage)
         end = maxPage;
            
      req.setAttribute("bottomLine", bottomLine);
      req.setAttribute("start", start);
      req.setAttribute("end", end);
      req.setAttribute("maxPage", maxPage);
      req.setAttribute("pageInt", pageInt);
      
      req.setAttribute("li", li);
      req.setAttribute("boardName", boardName);
      req.setAttribute("boardCount", boardCount);
      
      
      
      return "/WEB-INF/view/board/products.jsp";
} 
   @RequestMapping("myproducts") 
   public String myproducts(HttpServletRequest req, HttpServletResponse res) throws Exception {
      // TODO Auto-generated method stub
      
      //board session 처리한다.      
      if(req.getParameter("boardid")!=null) { //? boardid = 3
         session.setAttribute("boardid", req.getParameter("boardid"));}
          session.setAttribute("pageNum", "1");
      
      String boardid = (String) session.getAttribute("boardid");
      if(boardid==null) boardid = "1";
      String boardName = "";
      switch(boardid) {
 
      case "4":
          boardName = "찜한상품";
          break;
      case "5":
          boardName = "판매등록상품";
          break;
      case "6":
          boardName = "판매완료상품";
          break;
   
      }
      
      //page 설정
      if(req.getParameter("pageNum")!=null) { 
         session.setAttribute("pageNum", req.getParameter("pageNum"));}
      
      String pageNum = (String) session.getAttribute("pageNum");
      if(pageNum == null) pageNum ="1";
      
      int limit = 3; //한페이장 게시글 갯수
      int pageInt = Integer.parseInt(pageNum); //페이지 번호
      int boardCount = bd.boardCount(boardid); //전체 개시글 갯수
      
      int boardNum = boardCount -((pageInt-1)*limit);
      
      List<Board> li = bd.boardList(pageInt,limit,boardid);
      
      //pagging
      int bottomLine =3;
      int start = (pageInt-1)/bottomLine * bottomLine +1; //1,2,3->1 ,,4,5,6->4
      int end = start + bottomLine -1;
      int maxPage = (boardCount/limit) + (boardCount % limit ==0?0:1);
      if (end > maxPage)
         end = maxPage;
            
      req.setAttribute("bottomLine", bottomLine);
      req.setAttribute("start", start);
      req.setAttribute("end", end);
      req.setAttribute("maxPage", maxPage);
      req.setAttribute("pageInt", pageInt);
      
      req.setAttribute("li", li);
      req.setAttribute("boardName", boardName);
      req.setAttribute("boardCount", boardCount);
      
      
      
      return "/WEB-INF/view/board/myproducts.jsp";
}
   @RequestMapping("boardInfo") 
   public String boardInfo(HttpServletRequest req, HttpServletResponse res) throws Exception {
      // TODO Auto-generated method stub
      int num = Integer.parseInt(req.getParameter("num"));   
      Board board = bd.oneBoard(num);
      
      List<Comment> commentLi = bd.commentList(num);
      req.setAttribute("commentLi", commentLi);
      
      req.setAttribute("board", board);
      
      return "/WEB-INF/view/board/boardInfo.jsp";
   }
   
   @RequestMapping("boardUpdateForm") 
   public String boardUpdateForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
      // TODO Auto-generated method stub
      
        int num = Integer.parseInt(req.getParameter("num"));
      Board board = bd.oneBoard(num);      
      req.setAttribute("board", board);
      return "/WEB-INF/view/board/boardUpdateForm.jsp";
}
   
   @RequestMapping("boardUpdatePro") 
   public String boardUpdatePro(HttpServletRequest req, HttpServletResponse res) throws Exception {

      String path =
            req.getServletContext().getRealPath("/")+"image/board/";
      String filename = null;

      
      MultipartRequest multi = new MultipartRequest
            (req,path,10*1024*1024,"utf-8");
      int num = Integer.parseInt(multi.getParameter("num"));
      Board originboard = bd.oneBoard(num);
      
      String msg = "게시물 수정 실패";
      String url = "/board/boardForm?num="+originboard.getNum();
      if(originboard.getPass().equals(multi.getParameter("pass"))){
         
      
      String nfileName = multi.getFilesystemName("file1");
      Board board = new Board();
      board.setBoardid("1");
      board.setNum(num);
      board.setName(multi.getParameter("name"));
      board.setPass(multi.getParameter("pass"));
      board.setSubject(multi.getParameter("subject"));
      board.setContent(multi.getParameter("content"));
      
      if(nfileName==null) {
         board.setFile1(multi.getParameter("originfile"));
      }else {
         board.setFile1(nfileName);
      }
      System.out.println(board);
      int count = bd.updateBoard(board);      
      if (count>0) {
         msg="게시판 수정 완료";
         url="/board/boardInfo?num="+originboard.getNum();
      }
       }else  {
          msg = "비밀번호를 확인하세요.";
       }
      req.setAttribute("msg", msg);
      req.setAttribute("url", url);
      return "/WEB-INF/view/alert.jsp";
         
}
   
   @RequestMapping("boardDeleteForm") 
   public String boardDeleteForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
      // TODO Auto-generated method stub   
      req.setAttribute("num", req.getParameter("num"));
      return "/WEB-INF/view/board/boardDeleteForm.jsp";
}
   
   @RequestMapping("boardDeletePro")
   public String boardDeletePro(HttpServletRequest req, HttpServletResponse res) throws Exception {
      // TODO Auto-generated method stub
      int num = Integer.parseInt(req.getParameter("num"));
      Board board = bd.oneBoard(num);
      String msg = "삭제 불가합니다";
      String url = "/board/boardDeleteForm?num="+num;
      if (board.getPass().equals(req.getParameter("pass"))) {
         int count = bd.boardDelete(num);
         if (count>0) {
            msg = "게시글이 삭제 되었습니다";
            url = "/board/boardList";
         }
         
      } else {
         msg = "비밀번호 확인하세요";
      }
      req.setAttribute("msg", msg);
      req.setAttribute("url", url);
      return "/WEB-INF/view/alert.jsp";   
      
   }
   
   @RequestMapping("boardCommentPro") 
   public String boardCommentPro(HttpServletRequest req, HttpServletResponse res) throws Exception {
      // TODO Auto-generated method stub
      /*
       * req.setAttribute("comment", req.getParameter("comment"));
       * req.setAttribute("boardnum", req.getParameter("boardnum"));
       */
      String comment = req.getParameter("comment");
      int boardnum = Integer.parseInt(req.getParameter("boardnum"));
      bd.insertComment( comment,boardnum);
      Comment c= new Comment();
      c.setNum(boardnum);
      c.setContent(comment);
      req.setAttribute("c", c);
      return "/single/boardCommentPro.jsp";
   }
}