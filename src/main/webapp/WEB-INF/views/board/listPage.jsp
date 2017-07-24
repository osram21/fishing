<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%@ include file="../include/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style>
	.panel{
		width: 80%;
		margin: 0 auto;	
	}
	footer {
		margin-top: 20px; 
	}
	
</style>
			<div class="panel panel-default arrow left">
				<div class="panel-body">
			<div class="box-header">
					<h3 class="box-title">BOARD LIST(${login })</h3>
				</div>
			<div>
				<select name="searchType">
					<option value="n" ${cri.searchType=='null'? 'selected' : ''}>---</option>
					<option value="t"${cri.searchType=='t'? 'selected' : ''}>게시글제목</option>
					<option value="c" ${cri.searchType=='c'? 'selected' : ''}>게시글내용</option>
					<option value="w" ${cri.searchType=='w'? 'selected' : ''}>작성자</option>
					<option value="tc" ${cri.searchType=='tc'? 'selected' : ''}>게시글 제목 또는 게시글 내용</option>
					<option value="cw" ${cri.searchType=='cw'? 'selected' : ''}>게시글 내용 또는 작성자</option>
					<option value="tcw" ${cri.searchType=='tcw'? 'selected' : ''}>게시글 제목 또는 게시글 내용 또는 작성자</option>
				</select>
					<input type="text" value="${cri.keyword }" name="keyword">
					<button id="searchBtn">Search</button>
			</div>
	<table class="table table-condensed">
		<tr>
			<th>게시판 번호</th>
			<th>게시판 제목</th>
			<th>게시판 작성자</th>
			<th>게시판 날짜</th>
			<th>게시판 조회수</th>
		</tr>
			<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.boardNo }</td>
				<td><a href="read${pageMaker.makeSearch(pageMaker.cri.page)}&boardNo=${board.boardNo }&page=${pageMaker.cri.page}">${board.boardTitle }</a></td>
				<td>${board.memberId }</td>
				<td><fmt:formatDate value="${board.boardStartdate }" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>${board.boardCount }</td>
			</tr>
			</c:forEach>
	</table>
	
	<!-- 페이지 넘기는거 -->
		<div class="box-footer">
			<div class="text-center">
			<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li><a href="listPage${pageMaker.makeSearch(pageMaker.startPage-1) }">&laquo;</a></li>
			</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li ${pageMaker.cri.page==idx? 'class=active': ''}><a href="listPage${pageMaker.makeSearch(idx) }">${idx}</a></li>
				</c:forEach>
			<c:if test="${pageMaker.next }">
					<li><a href="listPage${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
			</c:if>
			</ul>
			</div>
		</div>
	<button onclick="btnNew()">글쓰기</button>
</div>
	</div>
<script type="text/javascript">
$(function () {
	$("#searchBtn").click(function() {
		var keyword =$("input[name='keyword']").val();
	    var searchType=$("select").val();
	    location.href="listPage?keyword="+keyword+"&searchType=" + searchType;
	})
});
	function btnNew(){
		location.href="register";
	}
</script>
<%@ include file="../include/footer.jsp"%>