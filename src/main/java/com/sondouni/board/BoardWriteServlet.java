package com.sondouni.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String path = "/WEB-INF/jsp/write.jsp";
        RequestDispatcher rq = req.getRequestDispatcher(path);
        rq.forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        res.setContentType("text/plain; charset=UTF-8");
//        res.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");
        String writer = req.getParameter("writer");
        System.out.println(title+""+ctnt+""+writer);
        BoardVO param = new BoardVO();
        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setWriter(writer);
        int result = BoardDAO.insBoard(param);
        switch (result){
            case 1:
                res.sendRedirect("/list"); // "주소"의 get방식으로 이동
                break;
            default:
                res.sendRedirect("/write");
                break;
        }
    }
}
