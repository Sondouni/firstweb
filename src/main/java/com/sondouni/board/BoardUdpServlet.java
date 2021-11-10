package com.sondouni.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/upd")
public class BoardUdpServlet extends HttpServlet {
    int iBoard;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        iBoard = Integer.valueOf(req.getParameter("iboard"));
        BoardVO vo = new BoardVO();
        vo.setIboard(iBoard);
        BoardVO ovo = BoardDAO.selBoard(vo);
        req.setAttribute("data",ovo);
        String path = "/WEB-INF/jsp/update.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO param = new BoardVO();
        param.setTitle(req.getParameter("title"));
        param.setCtnt(req.getParameter("ctnt"));
        param.setWriter(req.getParameter("writer"));
        System.out.println(req.getParameter("iboard"));
        param.setIboard((iBoard));
        int num = BoardDAO.updBoard(param);
        res.sendRedirect("/detail?iboard="+param.getIboard());

    }
}
