<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="joinForm" method="post">
		<label>아이디</label>
		<input type="text" name="memberId" placeholder="아이디"><br>
		<label>비밀번호</label>
		<input type="password" name="memberPass" placeholder="비밀번호"><br>
		<label>이름</label>
		<input type="text" name="memberName" placeholder="이름"><br>
		<label>이메일</label>
		<input type="text" name="memberEmail" placeholder="e-mail"><br>
		<button>가입하기</button>
	</form>
<!-- <script type="text/javascript">
	function btnNew(){
		//메인 포인트화면 완료되면 바꿀꺼임
		location.href="/board/listPage";
	}
</script> -->
</body>
</html>