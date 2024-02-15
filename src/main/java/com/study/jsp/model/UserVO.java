package com.study.jsp.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//VO클래스는 테이블의 컬럼과 1:1 매칭
//게터, 세터, ToString 설정

@Getter
@Setter
@ToString

//mapper.xml에서 캐시를 사용할 경우 Serializable 이어야 한다.

//Serializable - 데이터를 한 시스템에서 다른 시스템이나 네트워크로 전송하거나 
//데이터를 파일에 저장할 때, 그 데이터를 전송가능한 형태로 변환해야 할때 
//상속받는 인터페이스
public class UserVO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String userid;
  private String password;
  private String name;
  private String role;

}
