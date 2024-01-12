package dao;


import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import model.Cart;
import mybatis.MybatisConnection;

public class CartMybatisDao {
	SqlSession sqlSession = MybatisConnection.getConnection();
	private static final String ns = "cart.";
	
	
	public int addToAproducts(Cart cart) throws SQLException {
	  	
		int num = sqlSession.insert(ns+"addToAproducts", cart);
		sqlSession.commit();
		return num;
	}

	public List<Cart> jumunList(String userid) throws SQLException {
		List<Cart> li = sqlSession.selectList(ns+"jumunList", userid);
	return li;

	}
	public List<Cart> myList(String userid) throws SQLException {
		List<Cart> li = sqlSession.selectList(ns+"myList", userid);
	return li;

	}
	
	}

