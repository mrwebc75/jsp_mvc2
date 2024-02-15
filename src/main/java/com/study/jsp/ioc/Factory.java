package com.study.jsp.ioc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.study.jsp.dao.BoardMapper;
import com.study.jsp.dao.BoardMapperDAO;
import com.study.jsp.dao.UserMapper;
import com.study.jsp.dao.UserMapperDAO;
import com.study.jsp.srv.BoardService;
import com.study.jsp.srv.BoardServiceImpl;
import com.study.jsp.srv.UserService;
import com.study.jsp.srv.UserServiceImpl;

import myBatis.MyBatisManager;

//enum은 조금 특별한 class 이다. 
//싱글톤 객체를 쉽게 생성하는데 활용하기도 한다.
public enum Factory {

  INSTANCE;

  // 마이바티즈 SqlSession 객체 생성
  private SqlSessionFactory sqlSessionFactory = MyBatisManager.getSqlSessionFactory();
  private SqlSession sqlSession = sqlSessionFactory.openSession(false);// Not Autocommit

  private UserMapper userDao = new UserMapperDAO(sqlSession);
  private BoardMapper boardDao = new BoardMapperDAO(sqlSession);

  // jsp나 컨트롤러에서 서비스객체가 필요할 경우 Factory의 get서비스() 이용
  private UserService userSrv = new UserServiceImpl(userDao);

  public UserService getUserSrv() {
    return userSrv;
  }

  private BoardService boardSrv = new BoardServiceImpl(boardDao);

  public BoardService getBoardSrv() {
    return boardSrv;
  }

}
