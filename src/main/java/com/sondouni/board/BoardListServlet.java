package com.sondouni.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
    //안드로이드때는 json문자열을 리턴해줫다면, 지금은 html의 문자열(html태그)을 보내줄것임
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String field_ = req.getParameter("sh");
        String query_ = req.getParameter("shtext");
        List<BoardVO> list;
        List<String> index_list = new ArrayList<>();
        index_list.add("ㄱ"); index_list.add("ㄴ"); index_list.add("ㄷ"); index_list.add("ㄹ"); index_list.add("ㅁ"); index_list.add("ㅂ"); index_list.add("ㅅ");
        index_list.add("ㅇ"); index_list.add("ㅈ"); index_list.add("ㅊ"); index_list.add("ㅋ"); index_list.add("ㅌ"); index_list.add("ㅍ"); index_list.add("ㅎ");
        String field = "title";
        if(field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if(query_ != null && !query_.equals(""))
            query = query_;
        int num=0;
        for( int i = 0; i < index_list.size(); i++ ) { if( query.equals(index_list.get(i)) ) { num = 1; break; } }
        if(num==1){
            list = BoardDAO.selBoardListzx(field,query);
        }else {
            list = BoardDAO.selBoardList(field,query);
        }
        req.setAttribute("data",list);
        String path = "/WEB-INF/jsp/list.jsp";
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req,res); // path : 경로 ->여기서는 list.jsp가 되어야한다
        //포워딩 : 받은 데이터를 방향을 바꿔줘서 전달해준다

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
