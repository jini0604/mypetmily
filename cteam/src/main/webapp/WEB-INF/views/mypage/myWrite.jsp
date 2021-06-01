<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 글 / 댓글</title>
<style type="text/css">
#board, #comment {
  margin-top: 30px;
}

#comment {
	display: none;
}

table {
	
}


</style>
</head>
<body>
<h2>내가 쓴 글 / 댓글 보기</h2>
<div>
	<button type="button">내가 쓴 글</button>
	<button type="button">내가 쓴 댓글</button>
</div>
<div id="board" align="center"> 
	<table>
		<tr>
			<th>게시판</th>
			<th>글 제목</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${board }" var="board">
		<tr>
			<td>${board.board_subject }</td>
			<td>${board.board_title }</td>
			<td>${board.board_date }</td>
		</tr>
		</c:forEach>
	</table>
</div>

<div id="comment" align="center"> 
	<table>
		<tr>
			<th>내용</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${comment }" var="comment">
		<tr>
			<td>${comment.content }</td>
			<td>${comment.writedate }</td>
		</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>