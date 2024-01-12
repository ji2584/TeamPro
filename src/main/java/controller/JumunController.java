package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.BoardDao;

import dao.CartMybatisDao;
import dao.MemberDao;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Cart;

@WebServlet("/jumun/*")
public class JumunController extends MskimRequestMapping {
		
	@RequestMapping("jumunAdd") 
	public String jumunadd(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        CartMybatisDao cd = new CartMybatisDao();
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
        String pnumString = req.getParameter("pnum");
        int pnum = Integer.parseInt(pnumString);
        Cart c = new Cart();
        c.setUserid(id);
        c.setItemid(pnum);       
        
        cd.addToAproducts(c);
		
		req.setAttribute("msg", "추가 되었습니다");
		req.setAttribute("url", "/jumun/jumunList");
		return "/WEB-INF/view/alert.jsp";
		
	}
	
	@RequestMapping("jumunList")
	public String jumunList(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
		CartMybatisDao cd = new CartMybatisDao();
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
		List<Cart>  li = cd.jumunList(id);

		System.out.println(li);
		req.setAttribute("li", li);
		
		return "/WEB-INF/view/jumun/jumunList.jsp";
	}

	@RequestMapping("myList")
	public String myList(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
		CartMybatisDao cd = new CartMybatisDao();
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
		List<Cart>  li = cd.myList(id);

		System.out.println(li);
		req.setAttribute("li", li);
		
		return "/WEB-INF/view/jumun/myList.jsp";
	}	
}


