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

@WebServlet("/writeCtrl")
public class WriteController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String userid = request.getParameter("userid");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String nickname = request.getParameter("nickname");

    BoardDTO dto = new BoardDTO();
    dto.setUserid(userid);
    dto.setTitle(title);
    dto.setContent(content);
    dto.setNickname(nickname);

    BoardService boardSrv = Factory.INSTANCE.getBoardSrv();
    boardSrv.save(dto);

    response.sendRedirect("./listCtrl");

  }// doPost()
}
