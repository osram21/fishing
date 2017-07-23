<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<link href="${pageContext.request.contextPath}/resources/bootpage/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/bootpage/css/star-rating.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootpage/js/star-rating.min.js" type="text/javascript"></script>
	<div class="panel panel-default arrow left">
	<div class="panel-body">
	<form action="insert" method="post" class="form-horizontal">
		<div class="form-group">
				<label class="control-label col-sm-3">제목</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="pointTitle">
					</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3">작성자</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="memberId" value="${login }">
				</div>
		</div>
			<div class="form-group">
					<label class="control-label col-sm-3">장소</label>
				<div class="control-label col-sm-5">
					<input type="text" class="form-control" name="pointWhere">
				</div>
			</div>
		<!-- 여기서 이제 바꿔야됨 일딴 이렇게 함 ㅋㅋ -->
		<div class="form-group">
				<label class="control-label col-sm-3">내용</label>
					<div class="col-sm-5">
						<textarea type="text" class="form-control" rows="5" name="pointContent" id="comment"></textarea>
					</div>
		</div>
		<div class="col-sm-11 text-center">
			<!-- <button type="button" class="btn btn-default" onclick="btnNew()">저장</button> -->
			<input type="submit" value="전송">
		</div>
	</form>
</div>
</div>
<script type="text/javascript">
	function btnNew(){
		$(".form-horizontal").submit();
		location.href="listPage";
	}
</script>

		