package com.study.jsp.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.ioc.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

@WebServlet("/editCtrl")
public class EditController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String title = request.getParameter("title");
    String content = request.getParameter("content");

    int seq = 0;
    String seq_ = request.getParameter("seq");
    if (!seq_.isEmpty()) {
      seq = Integer.valueOf(seq_);
    }

    BoardDTO dto = new BoardDTO();
    dto.setTitle(title);
    dto.setContent(content);
    dto.setSeq(seq);

    BoardService boardSrv = Factory.INSTANCE.getBoardSrv();
    boardSrv.update(dto);

    response.sendRedirect("./listCtrl");

  }// doPost()

}
