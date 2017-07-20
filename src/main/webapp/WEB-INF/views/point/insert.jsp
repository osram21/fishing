<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<div>
			<label>제목</label>
			<input type="text" name="pointTitle"><br>
			<label>작성자</label>
			<input type="text" name="memberId" value="${login }"><br>
			<label>장소</label>
			<input type="text" name="pointWhere"><br>
			<label>내용</label>
			<textarea rows="20" cols="20" name="pointContent"></textarea>
		</div>
		<button onclick="btnNew()">글씀!리스트 ㄱ</button>
	</form>
</body>
</html>