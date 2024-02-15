package com.study.jsp.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.ioc.Factory;
import com.study.jsp.srv.BoardService;

@WebServlet("/listCtrl")
public class ListController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();

    // list.jsp는 로그인한 사용자만 접근 가능하도록 설정
    if (session.getAttribute("userid") == null) {
      response.sendRedirect("./board/login.jsp");
      return;// 서블릿에서는 리다이렉트 처리후 return 작성하지 않으면 아래 코드가 실행된다.
    }

    BoardService boardSrv = Factory.INSTANCE.getBoardSrv();
    request.setAttribute("list", boardSrv.findAll());

    // getRequestDispatcher()는 contextPath를 기준으로 자원을 구한다.
    RequestDispatcher dispatcher = request.getRequestDispatcher("board/list.jsp");
    dispatcher.forward(request, response);

  }
}
