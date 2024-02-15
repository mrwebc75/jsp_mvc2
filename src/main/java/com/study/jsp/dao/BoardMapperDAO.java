package com.study.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.jsp.model.BoardVO;

public class BoardMapperDAO implements BoardMapper {

  // 필요한 객체를 Factory에서 주입(DI)
  private SqlSession sqlSession;

  public BoardMapperDAO(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  private BoardMapper mp() {
    return sqlSession.getMapper(BoardMapper.class);
  }

  @Override
  public List<BoardVO> findAll() {
    return mp().findAll();
  }

  @Override
  public int save(BoardVO vo) {
    int result = 0;

    // 트랜잭션 예외처리
    try {
      result = mp().save(vo);
      sqlSession.commit();

    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }

    return result;
  }

  @Override
  public BoardVO getOne(int seq) {
    return mp().getOne(seq);
  }

  @Override
  public int increaseCnt(int seq) {

    int result = 0;

    try {
      result = mp().increaseCnt(seq);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }

    return result;
  }

  @Override
  public int update(BoardVO vo) {

    System.out.println(vo.toString());
    int result = 0;

    try {
      result = mp().update(vo);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }

    return result;

  }

  @Override
  public void delete(int seq) {

    try {
      mp().delete(seq);
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();
      sqlSession.rollback();
    }

  }

}
