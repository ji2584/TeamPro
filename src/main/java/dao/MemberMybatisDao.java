package dao;

import java.io.UnsupportedEncodingException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;

import model.Amem;
import mybatis.AMemberAnno;
import mybatis.MybatisConnection;

public class MemberMybatisDao {
	SqlSession sqlSession = MybatisConnection.getConnection();// class영역에 있어야함
	// MybatisConnection.close() 삭제
	private static final String NS = "amem.";

	public int insertMember(Amem amem) throws UnsupportedEncodingException, SQLException {

		System.out.println("mybatis insertMember");

		int num = sqlSession.getMapper(AMemberAnno.class).insertMember(amem);
		sqlSession.commit();

		return num;

	}

	public Amem oneMember(String id) throws SQLException {

		Amem mem = sqlSession.getMapper(AMemberAnno.class).oneMember(id);

		return mem;

	}

	public int updateMember(Amem amem) throws UnsupportedEncodingException, SQLException {

		int num = sqlSession.getMapper(AMemberAnno.class).updateMember(amem); // dml -> commit()

		sqlSession.commit();
		return num;

	}

	public int deleteMember(String id) throws UnsupportedEncodingException, SQLException {

		int num = sqlSession.getMapper(AMemberAnno.class).deleteMember(id); // dml -> commit()

		sqlSession.commit();
		return num;

	}

	public int passMember(String id, String chgpass) throws UnsupportedEncodingException, SQLException {

		Map map = new HashMap();
		map.put("id", id);
		map.put("pass", chgpass);

		int num = sqlSession.getMapper(AMemberAnno.class).passMember(map);

		sqlSession.commit();
		return num;

	}

}// class end