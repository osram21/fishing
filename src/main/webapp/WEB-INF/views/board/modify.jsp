<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div>
			<label>제목</label>
			<input type="text" name="boardTitle" value="${board.boardTitle }"><br>
			<label>작성자</label>
			<input type="text" name="memberId" value="${board.memberId }"><br>
			<label>내용</label>
			<textarea rows="20" cols="20" name="boardContent">${board.boardContent }</textarea>
		</div>
		<button onclick="btnNew()">수정</button>
<script type="text/javascript">
	function btnNew(){
		loaction.href="read";
	}
</script>
</body>
</html>