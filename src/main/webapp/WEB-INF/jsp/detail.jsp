<%@ page import="com.sondouni.board.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BoardVO vo = (BoardVO)request.getAttribute("data");
    int num = (Integer)request.getAttribute("num");
    List<BoardVO> list = (List)request.getAttribute("list");
    Collections.reverse(list);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>jsp 게시판 웹사이트</title>

</head>
<body>

    <div>제목:<%= vo.getTitle()%> </div>
    <div>내용:<%= vo.getCtnt()%> </div>
    <div>작성자:<%= vo.getWriter()%> </div>
    <div>작성일시:<%= vo.getRdt()%> </div>
    <div>
        <a href="/detail?iboard=<%= list.get(num+1).getIboard() %>&num=<%=num+1%>">이전</a>
    </div>
    <div>
        <a href="/del?iboard=<%= vo.getIboard() %>"><input type="button" value="삭제"></a>
    </div>
    <div>
        <a href="/upd?iboard=<%= vo.getIboard() %>"><input type="button" value="수정"></a>
    </div>
    <div>
        <a href="/detail?iboard=<%= list.get(num-1).getIboard() %>&num=<%=num-1%>">다음</a>
    </div>

</body>
</html>