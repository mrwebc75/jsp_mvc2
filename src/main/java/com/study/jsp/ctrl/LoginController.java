package com.study.jsp.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.ioc.Factory;
import com.study.jsp.model.UserDTO;
import com.study.jsp.srv.UserService;

@WebServlet("/loginCtrl")
public class LoginController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // filter를 적용하여 아래 코드 생략함
    // request.setCharacterEncoding("utf-8");

    // 사용자가 입력한 데이터 수신
    String userid = request.getParameter("userid");
    String password = request.getParameter("password");

    Map<String, String> loginInfo = new HashMap<String, String>();
    loginInfo.put("userid", userid);
    loginInfo.put("password", password);

    /*
     * select * from user where userid=#{userid} and password=#{password} 위의 쿼리문을
     * dao가 mybatis를 이용해서 실행 -> 결과리턴 UserVO
     * 
     * srv객체가 dao를 통해서 조회부탁
     * 
     * 컨트롤러에서 srv에 loginInfo를 넘기면서 부탁
     * 
     */

    // DB에 조회요청
    // 어떤서비스객체.메소드(loginInfo);
    UserService userSrv = Factory.INSTANCE.getUserSrv();
    UserDTO dto = userSrv.getOne(loginInfo);

    HttpSession session = request.getSession();

    if (dto != null) {// 로그인 성공
      session.setAttribute("userid", dto.getUserid());
      session.setAttribute("name", dto.getName());

/*
  sendRedirect()의 기준(루트)은 http://localhost:8090 까지 이므로 아래의 세가지 방법이 가능하다.      
  만약 설정해도 반영이 안될 경우는 Project>Clean 을 하면 해결된다.
    1. response.sendRedirect("/jsp_mvc2/listCtrl");
    2. response.sendRedirect(request.getContextPath() + "/listCtrl");
    3. response.sendRedirect("./listCtrl");  
*/      
      response.sendRedirect("./listCtrl");
    } else {// 로그인 실패
      response.sendRedirect("./index.jsp");
    }
  }

}
