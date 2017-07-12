<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet"   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
 <script src='resources/calender/js/jquery.min.js'></script>
<script   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
		<div>
			<label>제목:${board.boardTitle }</label><br>
			<label>작성자:${board.memberId }</label><br>
			<label>내용:${board.boardContent }</label>
		</div>
		<button id="modify">수정하기</button>
		<button id="delete">삭제하기</button>
		<button id="list">리스트가기</button>
			<form id="f1">
				<input type="hidden" name="boardNo" value="${board.boardNo }">
			</form>
<script type="text/javascript">
$(function () {
	$("#modify").click(function(){
		$("#f1").attr("action","modify");
		/* $("#f1").attr("method","get"); */
		$("#f1").submit();
	});
	$("#delete").click(function(){
		$("#f1").attr("action","delete");
		$("#f1").attr("method","post");
		$("#f1").submit();
	});
	$("#list").click(function(){
		location.href="listAll";
		//$("#f1").attr("action","listPage");
		//$("#f1").attr("method","get");
		//$("#f1").submit();
	});
});
</script>
</body>
</html>