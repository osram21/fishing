<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<link href="${pageContext.request.contextPath}/resources/bootpage/css/login.css" rel="stylesheet">
<style>
	footer{
		botton:0px;
		position: fixed;
	}
</style>
<div class="container">
	<div class="row">
	
		<div class="col-md-4 col-md-offset-4 text-center">
				
			<div class="search-box">
			<div class="panel panel-default arrow left">
		<div class="panel-body">
				<div class="caption">
					<h3>Fishing World</h3>
				</div>
				<form action="loginPost"  method="POST"  class="loginForm">
					<div class="input-group">
						<input type="text" name="memberId" class="form-control" placeholder="Full Name">
						<input type="password" name="memberPass" class="form-control" placeholder="Password">
						<input type="submit" id="submit" class="form-control" value="로그인">
						<!-- <input type="submit" id="submit" class="form-control" value="회원가입"> -->
						<button class="btn btn-default" onclick="btnNew()">회원가입</button>
					</div>
				</form>
			</div>
			</div>
			</div>
		</div>
		<!-- div class="col-md-4">
			<div class="aro-pswd_info">
				<div id="pswd_info">
					<h4>Password must be requirements</h4>
					<ul>
						<li id="letter" class="invalid">At least <strong>one letter</strong></li>
						<li id="capital" class="invalid">At least <strong>one capital letter</strong></li>
						<li id="number" class="invalid">At least <strong>one number</strong></li>
						<li id="length" class="invalid">Be at least <strong>8 characters</strong></li>
						<li id="space" class="invalid">be<strong> use [~,!,@,#,$,%,^,&,*,-,=,.,;,']</strong></li>
					</ul>
				</div>
			</div>
		</div> -->
	</div>
</div>
<script>
	function btnNew(){
		location.href="fishing/join/joinForm";
	}
</script>
<%@ include file="../include/footer.jsp"%>