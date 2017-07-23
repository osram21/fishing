<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page session="false" %>
<!DOCTYPE html>
<%@ include file="../include/header.jsp"%>
<%-- <link href="${pageContext.request.contextPath}/resources/bootpage/css/main.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/resources/bootpage/css/star-rating.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootpage/js/star-rating.min.js" type="text/javascript"></script>

<style>
 .row {
	padding: 10px;
} 

.btn-default {
	float: rigth;
}

.col-md-4 {
	float: right;
}

#btn {
	float: right;
}
</style>

<div class="container">
	<div class="row">
		<div class="col-md-11">
			<h2 class="page-header">포인트 리스트</h2>
			<div class="row">
				<div class="box-body">
					<select name="searchType">
						<option value="n" ${cri.searchType=='null'? 'selected' : ''}>---</option>
						<option value="t" ${cri.searchType=='t'? 'selected' : ''}>게시글제목</option>
						<option value="c" ${cri.searchType=='c'? 'selected' : ''}>게시글내용</option>
						<option value="w" ${cri.searchType=='w'? 'selected' : ''}>작성자</option>
						<option value="tc" ${cri.searchType=='tc'? 'selected' : ''}>게시글제목 또는 게시글 내용</option>
						<option value="cw" ${cri.searchType=='cw'? 'selected' : ''}>게시글내용 또는 작성자</option>
						<option value="tcw" ${cri.searchType=='tcw'? 'selected' : ''}>게시글제목 또는 게시글 내용 또는 작성자</option>
					</select> <input type="text" value="${cri.keyword }" name="keyword">
						<button type="button" class="btn btn-default" id="searchBtn">Search</button>
							<div class="col-md-4">
								<button type="button" class="btn btn-default" id="btn" onclick="btnNew()">글쓰기</button>
							</div>
				</div>
			</div>
					<section class="comment-list">
						<!-- First Comment -->
						<c:forEach var="point" items="${list }">
				<article class="row">
					<div class="col-md-2 col-sm-2 hidden-xs">
						<figure class="thumbnail">
							<img class="img-responsive" src="http://www.keita-gaming.com/assets/profile/default-avatar-c5d8ec086224cb6fc4e395f4ba3018c2.jpg" />
						</figure>
					</div>
						<div class="col-md-10 col-sm-10">
							<div class="panel panel-default arrow left">
								<div class="panel-body">
									<!-- 여기에 클릭버튼 해야징 -->
								<header class="text-left">
									<div class="comment-user">
										<i class="fa fa-user">${point.memberId }</i>
									</div>
										<time class="comment-date" datetime=""><i class="fa fa-clock-o"></i><%-- <fmt:formatDate value="${point.pointDate }"pattern="yyyy-MM-dd HH:mm" /> --%>
										</time>
								</header>
				<div class="comment-post">
					<p>제목 : ${point.pointTitle}</p>
				</div>
				<div class="comment-post">
					<p>포인트 장소 : ${point.pointWhere}</p>
				</div>
				<div class="comment-post" id="content">
					<p>포인트 내용 : ${point.pointContent }</p>
					<p><a href="read${pageMaker.makeSearch(pageMaker.cri.page)}&pointNo=${point.pointNo }&page=${pageMaker.cri.page}">더보기</a></p>
				</div>
				<div class="row">
					<div class="col-sm-4" id="form1">
						<label for="input-7-xs" class="control-label">장소 평점</label> 
						<input id="input-3" name="input-3" value="1.2" class="rating-loading">
					</div>
					<div class="col-sm-4" id="form2">
						<label for="input-7-xs" class="control-label">어류 평점</label> 
						<input id="input-4" name="input-3" value="1" class="rating-loading">
					</div>
				</div>
				<p class="text-right">
					<a href="#" class="btn btn-default btn-sm"><i class="fa fa-reply"></i> reply</a>
				</p>
			</div>
		</div>
	</div>
</article>
</c:forEach>
</section>
<div class="box-footer">
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
		<li><a
			href="listPage${pageMaker.makeSearch(pageMaker.startPage-1) }">&laquo;</a></li>
	</c:if>
	<c:forEach begin="${pageMaker.startPage }"
		end="${pageMaker.endPage }" var="idx">
		<li ${pageMaker.cri.page==idx? 'class=active': ''}><a
			href="listPage${pageMaker.makeSearch(idx) }">${idx}</a></li>
	</c:forEach>
	<c:if test="${pageMaker.next }">
		<li><a
			href="listPage${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
	</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	$("#searchBtn").click(
		function() {
			var keyword = $("input[name='keyword']").val();
			var searchType = $("select").val();
			location.href = "listPage?keyword=" + keyword
							+ "&searchType=" + searchType;
		})
});
function btnNew() {
	location.href = "insert";
}
$(document).on('ready', function(){
    $('#input-3').rating({displayOnly: true, step: 0.2});
    $('#input-4').rating({displayOnly: true, step: 0.5});
});
</script>

<%@ include file="../include/footer.jsp"%>