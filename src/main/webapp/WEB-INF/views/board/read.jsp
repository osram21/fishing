<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!--  <script src='resources/calender/js/jquery.min.js'></script> -->
<script   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
		$("#f1").attr("method","get");
		$("#f1").submit();
	});
	$("#delete").click(function(){
		$("#f1").attr("action","delete");
		$("#f1").attr("method","post");
		$("#f1").submit();
	});
	$("#list").click(function(){
		location.href="listPage";
		//$("#f1").attr("action","listPage");
		//$("#f1").attr("method","get");
		//$("#f1").submit();
	});
});
</script>
	<!-- <div>
		<h1>댓글을 넣어봅시다</h1>
			<label>작성자</label>
			<input type="text" placeholder="아이디" id="replywriter"><br>
			<label>댓글 내용</label>
			<input type="text" placeholder="내용 적기" id="replycontent">
	</div>
	<button>댓글 추가</button>
		<div>
			<ul>
				<li>댓글 리스트</li>
			</ul>
		</div> -->
		<div class="row"><!-- 댓글 -->
		<div class="col-md-12">
			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">댓글 추가</h3>
				</div>
				<div class="box-body">
					<label for="newReplyWriter">작성자</label>
					<input type="text" placeholder="아이디" id="newReplyWriter" class="form-control">
					<br>
					<label for="newReplyText">댓글내용</label>
					<input type="text" placeholder="Reply Text" id="newReplyText" class="form-control">
				</div>
				<div class="box-footer">
					<button class="btn btn-primary" id="btnadd">댓글 추가</button>
				</div>
			</div><!-- 댓글 추가 -->
			<%-- <ul class="timeline">
				<li class="time-label" id="repliesList">
					<span class="bg-green" id="btnList">댓글 리스트<small id="replycnt">[${board.reply }]</small></span>
				</li>
			</ul>  --%>
		</div>
<script type="text/javascript">
	var page_bar = 1;
</script>
</body>
</html>