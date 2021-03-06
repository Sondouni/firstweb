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
    <div>
        <a href="/write"><input type="button" value="글쓰기"></a>
    </div>
    <form>
        <fieldset>
            <legend></legend>
            <label>검색</label>
            <select name ="sh">
                <option value="title">제목</option>
                <option value="writer">작성자</option>
            </select>
            <label>검색어</label>
            <input type="text" name ="shtext" value=""/>
            <input type="submit" value="검색">
        </fieldset>
    </form>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>작성일시</th>
        </tr>
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
    </table>
</body>
</html>