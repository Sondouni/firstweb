<%@ page import="com.sondouni.board.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //자바 메소드를 사용가능
    List<BoardVO> list = (List<BoardVO>)request.getAttribute("data");
    Collections.reverse(list);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리스트</title>
    <style>
        table, td, th{
            border-collapse: collapse ;
            border: 1px solid #000;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class = "row">
            <table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
                <thead>
                <tr>
                    <th style="background-color: #eeeeee; text-align: center;">번호</th>
                    <th style="background-color: #eeeeee; text-align: center;">제목</th>
                    <th style="background-color: #eeeeee; text-align: center;">작성자</th>
                    <th style="background-color: #eeeeee; text-align: center;">작성일</th>
                </tr>
                </thead>
                <tbody>
                <% for(BoardVO vo: list){ %>
                <tr>
                    <td><%=vo.getIboard() %></td>
                    <td>
                        <a href="/detail?iboard=<%= vo.getIboard() %>">
                            <%=vo.getTitle() %>
                        </a>
                    </td>
                    <td><%=vo.getWriter() %></td>
                    <td><%=vo.getRdt() %></td>
                </tr>
                <% } %>
                </tbody>
            </table><a href = "write.jsp" class="btn btn-primary pull-right">글쓰기</a>
        </div>
    </div> <!-- 애니매이션 담당 JQUERY -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js">
    </script> <!-- 부트스트랩 JS -->
    <script src="js/bootstrap.js">
    </script>


</body>
</html>