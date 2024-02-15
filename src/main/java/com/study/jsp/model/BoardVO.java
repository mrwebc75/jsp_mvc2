package com.study.jsp.model;

import java.io.Serializable;
/*
 * java.util.Date - 날짜시간 저장
 * 
 * java.sql.Date - 날짜만 저장
 */
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO implements Serializable {

  private static final long serialVersionUID = 1L;

  private int seq;
  private String title;
  private String nickname;
  private String content;
  private Date regdate;
  private int cnt;
  private String userid;

}
