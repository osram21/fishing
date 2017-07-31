<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<link href="${pageContext.request.contextPath}/resources/bootpage/css/login.css" rel="stylesheet">
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4 text-center">
			<div class="search-box">
				<div class="caption">
					<h3>Advance Password Validation</h3>
					<p>Find to All</p>
				</div>
				<form action="loginPost"  method="POST"  class="loginForm">
					<div class="input-group">
						<input type="text" name="memberId" class="form-control" placeholder="Full Name">
						<input type="password" name="memberPass" class="form-control" placeholder="Password">
						<input type="submit" id="submit" class="form-control" value="Submit">
					</div>
				</form>
			</div>
		</div>
		 		<%-- <c:if test="${empty login }">
                     <a href="${pageContext.request.contextPath }/point/listPage" class="form-control">Login / Sign In</a>
                  </c:if> 
                  <c:if test="${!empty login }">
                     <a href="logout">Logout / Sign Out</a>
                  </c:if> --%>
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