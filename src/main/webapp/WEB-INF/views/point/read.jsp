<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<link href="${pageContext.request.contextPath}/resources/bootpage/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/bootpage/css/star-rating.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootpage/js/star-rating.min.js" type="text/javascript"></script>
		<div class="panel panel-default arrow left">
				<div class="panel-body">
			<p class="text-danger">제목:${point.pointTitle }</p>
			<p class="text-danger">작성자:${point.memberId }</p>
			<p class="text-danger">내용:${point.pointContent }</p>
		
		<button id="modify">수정하기</button>
		<button id="delete">삭제하기</button>
		<button id="list">리스트가기</button>
		<form id="f1">
			<input type="hidden" name="pointNo" value="${point.pointNo }">
		</form>
		</div>
		</div>
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
		/*삭제 예외처리해야됨*/
	});
	$("#list").click(function(){
		location.href="listPage";
		//$("#f1").attr("action","listPage");
		//$("#f1").attr("method","get");
		//$("#f1").submit();
	});
});
</script>