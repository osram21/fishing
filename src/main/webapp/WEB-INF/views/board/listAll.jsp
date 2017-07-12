<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>게시판 번호</th>
			<th>게시판 제목</th>
			<th>게시판 작성자</th>
			<th>게시판 날짜</th>
			<th>게시판 조회수</th>
		</tr>
			<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.boardNo }</td>
				<td><a href="read?boardNo=${board.boardNo }">${board.boardTitle }</a></td>
				<td>${board.memberId }</td>
				<td>${board.boardStartdate }</td>
				<td>${board.boardCount }</td>
			</tr>
			</c:forEach>
	</table>
	<button onclick="btnNew()">글쓰기</button>
<script type="text/javascript">
	function btnNew(){
		location.href="register";
	}
</script>
</body>
</html>
