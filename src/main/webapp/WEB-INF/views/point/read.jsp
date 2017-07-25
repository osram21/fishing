<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>

<link href="${pageContext.request.contextPath}/resources/bootpage/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/bootpage/css/star-rating.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootpage/js/star-rating.min.js" type="text/javascript"></script>
	<div class="container">
	<div class="row">
		<div class="col-md-12">
		<section class = "comment-list">
			
				<div class="col-md-12 col-sm-12"> 
				<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-md-12 ">
						<h2 class="page-header">${point.pointTitle }</h2><!--타이틀 제목  -->
							
					</div>
						<div class="col-md-5">
							${point.memberId }님 &nbsp;
							<time class="comment-date" ><i class="fa fa-clock-o"></i><fmt:formatDate value="${point.pointDate }" pattern="yyyy-MM-dd HH:mm"/>
								</time>
							&nbsp;조회수 ${point.pointCount }
						</div>
					 <div class="col-md-10" style="margin-top: 20px">
						<p class="text-danger">${point.pointContent }</p>
					</div>
					<div class="col-md-10">
					<button id="modify">수정하기</button>
					<button id="delete">삭제하기</button>
					<button id="list">리스트가기</button>
					</div>
						<form id="f1">
							<input type="hidden" name="pointNo" value="${point.pointNo }">
						</form>
					<!-- 댓글 -->
		<div class="col-md-11">
			<div class="box box-success">
				<div class="box-header">
					<h3 class="page-header">댓글 추가</h3>
				</div>
				<div class="box-body">
					<label for="newReplyText">댓글내용</label>
					<textarea type="text" class="form-control" rows="5" name="pointContent" id="newReplyText"></textarea>
					<br>
					<!-- <label for="newReplyWriter">작성자</label> -->
					<input type="hidden" placeholder="아이디" id="newReplyWriter" class="form-control" value="${login }">
				</div>
				<div class="row">
					<div class="col-sm-4" id="form1">
						<label for="input-4" class="control-label">장소 평점</label>
						<input name="inpit-4" value="${pr.prF }" id="prF"class="rating rating-loading" data-show-clear="false" data-show-caption="true">
						
					</div>
					<div class="col-sm-4" id="form2">
						<label for="input-4" class="control-label">어류 평점</label> 
						<input name="input-4" value="${pr.prS }" id="prS" class="rating rating-loading" data-show-clear="false" data-show-caption="true">
					</div>
				</div>
				<div class="box-footer">
					<button class="btn btn-default" id="btnadd" style="disply:block">댓글 추가</button>
				</div>
			</div><!-- 댓글 추가 -->
			 <ul class="timeline">
				<li class="time-label" id="repliesList">
					<span class="bg-green" id="btnList">댓글 리스트</span>
					<!-- <button id="btnList">댓글 리스트</button> -->
				</li>
			</ul> 
		</div>
			</div>
				</div>
			</div>
</section>
	</div>
		</div>
		</div>
	<!-- 모달 -->
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
			<li class="replyLi" data-rno={{prNo}} id="toggle">
		<i class="fa fa-comments bg-blue"></i>
		<div class="timeline-item">		
			<span class="time">
				<i class="fa fa-clock-o"></i>{{regdate}}
			</span>
			<h3 class="timeline-header"><strong>{{replyNo}}</strong>-{{memberId}}</h3>
				<div class="timeline-body">{{prContent}}</div>
					<div class="timeline-footer">
						<a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modifyModal"
							data-rno={{prNo}} data-text={{prContent}} data-replyer={{memberId}}>
							수정
						</a>
						<button class="btndel" class="btn btn-primary" data-rno={{prNo}}>삭제</button>
				</div>
		</div>
	</li>
		{{/list}}		
	</script>
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
/* $('#input-4').on('rating.hoverleave', function(event, target) {
    console.log(target);
}); */
	var page_bar = 1;
	var bno = ${point.pointNo}
	
	function getAllList(page){
		$.ajax({
			url:"${pageContext.request.contextPath}/ptreply/"+bno+"/"+page, //커맨드 가는 주소
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
		var writer = $("#newReplyWriter").val(); //태그 작성자 가져오기
		var text = $("#newReplyText").val();	// 태그 내용(댓글쓴 글) 가져오기
		var prF = $("#prF").val();
		var prS = $("#prS").val();
		var sendData = {pointNo:bno,prContent:text,memberId:writer,prF:prF,prS:prS};//데이터 보내는거
		
		$.ajax({
			url:"${pageContext.request.contextPath}/ptreply/add",
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
	
	$(document).on('rating.change',"#prF", function(event, value, caption) {
	    console.log(value);
	    console.log(caption);
	});	
	
	//리스트
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
		var ptNo = $(".modal-title").text();
		var ptcontent = $("#replytext").val();
		var sendData = {replyContent:replycontent};
		
		$.ajax({
			url:"${pageContext.request.contextPath}/ptreply/"+ptNo,
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
			url:"${pageContext.request.contextPath}/ptreply/"+replyNo,
			type:"delete",
			success:function(data){
				if(data=="success"){
					alert("삭제");
				}
				getAllList(page_bar);
			}
		})
	})
	
	//평점 에이잭스를 해봐야되는곳
	
</script>
<%@ include file="../include/footer.jsp"%>