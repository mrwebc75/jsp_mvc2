package com.study.jsp.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ioc.Factory;
import com.study.jsp.srv.BoardService;

@WebServlet("/deleteCtrl")
public class DeleteController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // seq 처리 로직
    int seq = 0;

    String seq_ = request.getParameter("seq");
    if (!seq_.isEmpty()) {
      seq = Integer.valueOf(seq_);
    }

    BoardService boardSrv = Factory.INSTANCE.getBoardSrv();
    boardSrv.delete(seq);

    response.sendRedirect("./listCtrl");

  }
}
