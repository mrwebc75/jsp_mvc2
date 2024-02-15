package com.study.jsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

  private String encoding = null;

  @Override
  // init 메소드는 이 클래스의 객체가 생성될 때 딱 한번만 실행됨
  public void init(FilterConfig filterConfig) throws ServletException {
    encoding = "utf-8";
  }

  @Override
  // doFilter 메소드는 모든 서블릿에 대한 요청이 있을 때마다 매번 실행됨
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    // 1. 서블릿 실행전 처리할 코드
    req.setCharacterEncoding(encoding);
    // System.out.println("이 메세지는 서블릿 실행전 출력됩니다.");

    // 2. 다음 서블릿으로 흐름을 넘긴다.
    chain.doFilter(req, res);

    // 3. 서블릿 실행후 처리할 코드
    // System.out.println("이 메세지는 서블릿 실행후 출력됩니다.");
  }

}
