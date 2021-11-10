package com.sondouni.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
    //안드로이드때는 json문자열을 리턴해줫다면, 지금은 html의 문자열(html태그)을 보내줄것임
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<BoardVO> list = BoardDAO.selBoardList(req.getParameter("sh"),req.getParameter("shtext"));
        req.setAttribute("data",list);
        String path = "/WEB-INF/jsp/list.jsp";
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req,res); // path : 경로 ->여기서는 list.jsp가 되어야한다
        //포워딩 : 받은 데이터를 방향을 바꿔줘서 전달해준다

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
