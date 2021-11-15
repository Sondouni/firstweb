package com.sondouni.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BoardVO vo = new BoardVO();
        vo.setIboard(Integer.parseInt(req.getParameter("iboard")));
        System.out.println(vo.getIboard());
        //이전,다음
        req.setAttribute("num",Integer.parseInt(req.getParameter("num")));
        req.setAttribute("list",BoardDAO.selBoardList());
        //
        for(BoardVO vsso : BoardDAO.selBoardList()){
            System.out.println(vsso.getIboard());
        }
        BoardVO vvo = BoardDAO.selBoard(vo);
        req.setAttribute("data",vvo);
        String path = "/WEB-INF/jsp/detail.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
