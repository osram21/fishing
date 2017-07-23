<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="modify" method="post">
		<input type="hidden" name="pointNo" value="${point.pointNo }">
		<div>
			<label>제목</label>
			<input type="text" name="pointTitle" value="${point.pointTitle }"><br>
			<label>작성자</label>
			<input type="text" name="memberId" value="${point.memberId }"><br>
			<label>장소</label>
			<input type="text" name="pointWhere" value="${point.pointWhere }"><br>
			<label>내용</label>
			<textarea rows="20" cols="20" name="pointContent">${point.pointContent }</textarea>
		</div>
		<button onclick="btnNew()">수정</button>
</form>
<script type="text/javascript">
	function btnNew(){
		location.href="read";
	}
</script>