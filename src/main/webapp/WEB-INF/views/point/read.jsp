<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!DOCTYPE html>
		<div>
			<label>제목:${point.pointTitle }</label><br>
			<label>작성자:${point.memberId }</label><br>
			<label>내용:${point.pointContent }</label>
		</div>
		<button id="modify">수정하기</button>
		<button id="delete">삭제하기</button>
		<button id="list">리스트가기</button>
		<form id="f1">
			<input type="hidden" name="pointNo" value="${point.pointNo }">
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