<%@ page import="com.sondouni.board.BoardVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BoardVO vo =(BoardVO)request.getAttribute("data");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
<div>수정</div>
<form action ="/upd" method="post" id="fm">
    <input type="hidden" name = "iboard" value="<%= vo.getIboard() %>">
    <div><input type = "text" name="title" placeholder="제목" value="<%= vo.getTitle() %>"></div>
    <div>
        <textarea name="ctnt" placeholder="내용" ><%= vo.getCtnt() %></textarea>
    </div>
    <div><input type = "text" name="writer" placeholder="글쓴이" value="<%= vo.getWriter() %>"></div>
    <div>
        <input type="submit" value="저장">
        <input type="reset" value="초기화">
        <input type = "button" value="모두삭제" onclick="removeAll()">
    </div>
</form>
<script>
    function removeAll(){
        var fm = document.querySelector('#fm');
        if(fm){
            fm.title.value = '';
            fm.ctnt.value = '';
            fm.writer.value = '';

        }
    }
</script>
</body>
</html>