package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.MemberMybatisDao;
import kic.mskim.RequestMapping;


@RequestMapping("/admin")
public class AdminController {
	  amem bd = new amem();
	   AMemberMybatisDao md = new AMemberMybatisDao();
	   HttpSession session;
	@RequestMapping("main") //~~/board/index
	   public String main(HttpServletRequest req, HttpServletResponse res) throws Exception {
		      // TODO Auto-generated method stub
		      
	
		      
		      return "/WEB-INF/view/admin/main.jsp";
		}
	
	
	
}
