<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		<div>
			<label>제목</label>
			<input type="text" name="boardTitle"><br>
			<label>작성자</label>
			<input type="text" name="memberId"><br>
			<label>내용</label>
			<textarea rows="20" cols="20" name="boardContent"></textarea>
		</div>
		<button onclick="btnNew()">글씀!리스트 ㄱ</button>
	</form>
<script type="text/javascript">
	function btnNew(){
		location.href="listAll";
	}		
</script>
</body>
</html>