package com.sondouni.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/del")
public class BoardDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO vo = new BoardVO();
        vo.setIboard(Integer.parseInt(req.getParameter("iboard")));
        int result = BoardDAO.delBoard(vo);


        res.sendRedirect("/list");
//        BoardListServlet list = new BoardListServlet();
//        list.doGet(req,res);
//        List<BoardVO> list = BoardDAO.selBoardList();
//        req.setAttribute("data",list);
//        String path = "/WEB-INF/jsp/list.jsp";
//        RequestDispatcher rd = req.getRequestDispatcher(path);
//        rd.forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
