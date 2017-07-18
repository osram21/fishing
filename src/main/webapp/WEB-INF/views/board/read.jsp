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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

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
				<input type="hidden" name="list" value="${cri.page }">
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
					<input type="text" placeholder="아이디" id="newReplyWriter" class="form-control" value="${login }">
					<br>
					<label for="newReplyText">댓글내용</label>
					<input type="text" placeholder="Reply Text" id="newReplyText" class="form-control">
				</div>
				<div class="box-footer">
					<button class="btn btn-primary" id="btnadd">댓글 추가</button>
				</div>
			</div><!-- 댓글 추가 -->
			 <ul class="timeline">
				<li class="time-label" id="repliesList">
					<span class="bg-green" id="btnList">댓글 리스트</span>
				</li>
			</ul> 
		</div>
		<ul class="pagination"></ul>
	</div><!-- end 댓글 -->
	<!-- 이것이 모달! -->
		<div id="modifyModal" class="modal modal-primary fade" role="dialog">
	  <div class="modal-dialog">
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title"></h4> <!-- title rno 값 -->
	      </div>
	      <div class="modal-body" data-rno>
	        <p><input type="text" id="replytext" class="form-control"></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-info" id="replyModBtn" data-dismiss="modal">Modify</button>
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div> 
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<script id="temp" type="text/x-handlebars-template">
		{{#list}}
			<li class="replyLi" data-rno={{replyNo}}>
		<i class="fa fa-comments bg-blue"></i>
		<div class="timeline-item">		
			<span class="time">
				<i class="fa fa-clock-o"></i>{{regdate}}
			</span>
			<h3 class="timeline-header"><strong>{{replyNo}}</strong>-{{memberId}}</h3>
				<div class="timeline-body">{{replyContent}}</div>
					<div class="timeline-footer">
						<a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modifyModal"
							data-rno={{replyNo}} data-text={{replyContent}} data-replyer={{memberId}}>
							수정
						</a>
						<button class="btndel" class="btn btn-primary" data-rno={{replyNo}}>삭제</button>
				</div>
		</div>
	</li>
		{{/list}}
		
	</script>	
<script type="text/javascript">
	var page_bar = 1;
	var bno = ${board.boardNo}
	
	// 다가지고 오는거????????
	function getAllList(page){
		$.ajax({
			url:"${pageContext.request.contextPath}/reply/"+bno+"/"+page, //커맨드 가는 주소
			type:"get", //가는 방식 get이냐 post냐
			dateType:"json", //데이터 타입 젝슨 뭐 그런거...
			success:function(data){
				console.log(data);
				$(".replyLi").remove();
				var source = $("#temp").html(); //temp 모달? 붙이는건가
				var template = Handlebars.compile(source); //handlebars 쓰는거
				$(".timeline").append(template(data));
			}
		})
	}
	
	//댓글 추가
	$("#btnadd").click(function(){//추가 버튼 눌럿을때
		var writer = $("#newReplyWriter").val(); //
		var text = $("#newReplyText").val();
		var sendData = {boardNo:bno,replyContent:text,memberId:writer};//데이터 보내는거
		
		$.ajax({
			url:"${pageContext.request.contextPath}/reply/add",
			type:"post",
			dataType:"text",
			data:JSON.stringify(sendData),
			headers:{"Content-Type":"application/json"},
			success:function(data){
				console.log(data);
				getAllList(page_bar);
			}
		})
	})
	
	//리스트 나옴
	$("#btnList").click(function(){
		getAllList(page_bar);
	});
	
	//수정 버튼
	$(document).on("click",".btn-primary",function(){
		var rno = $(this).attr("data-rno");
		var replyContent = $(this).attr("data-text");
		var memberId = $(this).attr("data-replyer");
		$(".modal-title").html(rno);
		$("#replytext").val(replyContent);
		$("#modifyModal").show();
	})
	
	// 모달 수정 버튼 누르면!!!
	$("#replyModBtn").click(function(){
		var replyNo = $(".modal-title").text();
		var replycontent = $("#replytext").val();
		var sendData = {replyContent:replycontent};
		
		$.ajax({
			url:"${pageContext.request.contextPath}/reply/"+replyNo,
			type:"put",
			dataType:"text",
			data:JSON.stringify(sendData),
			headers:{"Content-Type":"application/json"},
			success:function(data){
				console.log(data);
				getAllList(page_bar);
			}
		})
	})
	
	//삭제
	$(document).on("click",".btndel",function(){
		var replyNo = $(this).attr("data-rno");
		
		$.ajax({
			url:"${pageContext.request.contextPath}/reply/"+replyNo,
			type:"delete",
			success:function(data){
				if(data=="success"){
					alert("삭제");
				}
				getAllList(page_bar);
			}
		})
	})
</script>
</body>
</html>