package com.study.jsp.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ioc.Factory;
import com.study.jsp.srv.BoardService;

@WebServlet("/readCtrl")
public class ReadController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int seq = 0;

    String seq_ = request.getParameter("seq");
    if (!seq_.isEmpty()) {
      seq = Integer.valueOf(seq_);
    }

    BoardService boardSrv = Factory.INSTANCE.getBoardSrv();
    request.setAttribute("dto", boardSrv.getOne(seq));

    // getRequestDispatcher()는 contextPath를 기준으로 자원을 구한다.
    RequestDispatcher dispatcher = request.getRequestDispatcher("board/read.jsp");
    dispatcher.forward(request, response);

  }
}
