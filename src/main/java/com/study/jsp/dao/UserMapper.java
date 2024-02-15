package com.study.jsp.dao;

import java.util.Map;

import com.study.jsp.model.UserVO;

public interface UserMapper {

  // 매퍼xml의 id값이 추상메소드 이름
  // resultType 값을 리턴타입으로 지정
  UserVO getOne(Map<String, String> loginInfo);

}
