package com.study.jsp.dao;

import java.util.List;

import com.study.jsp.model.BoardVO;

public interface BoardMapper {

  List<BoardVO> findAll();

  int save(BoardVO vo);

  BoardVO getOne(int seq);

  int increaseCnt(int seq);

  int update(BoardVO vo);

  void delete(int seq);
}
