<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
	nav{
		height: 95px;
	}
	
</style>
<link href="${pageContext.request.contextPath}/resources/bootpage/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/bootpage/css/star-rating.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootpage/js/star-rating.min.js" type="text/javascript"></script> 

<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootpage/lang/summernote-ko-KR.js"></script>

	<div class="panel panel-default arrow left">
	<div class="panel-body">
	<form action="insert" method="post" class="form-horizontal" enctype="multipart/form-data">
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
						<textarea type="text" class="form-control" id="summernote" name="pointContent"></textarea>
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
	
	 function sendFile(file, editor, welEditable) {
	    data = new FormData();
	    data.append("file", file);
	    	$.ajax({
	        	data: data,
	        	type: "POST",
	        	url: "${pageContext.request.contextPath}/point/imageUpload",
	        	cache: false,
	        	contentType: false,
	        	enctype: "multipart/form-data",
	        	processData: false,
	        	success: function (url){ 
	        		 var image = "displayTitleFile?uploadPfile="+url;//여기를 바꾸면 섬네일이 바뀜
	            	 $("#summernote").summernote("editor.insertImage",image);
	            	  /* editor.insertImage(welEditable, image); */
	            	 /*  $(".thumbnail").append("<li><img src='"+url+"'</li>"); */
	        	}
	    	});
		}  
	
	
	$(function(){
		$(document).ready(function() {
		       $("#summernote").summernote();
		 });	
	})
	
	$(function(){
		$('#summernote').summernote({
	        onblur : function(e) {
	            $('#summercontent').html($('#summernote').code());
	        },
	    	height : 250, // set editor height
	    	minHeight : 100, // set minimum height of editor
	    	maxHeight : null, // set maximum height of editor
	    	lang : 'ko-KR', // default: 'en-US'
	    	callbacks:{
	    	onImageUpload : function(files,editor,welEditable) {
	                 sendFile(files[0], editor, welEditable); 
	                /* uploadImage(image[0]); */
	        	}
	    	}
	    	
		})
	});
</script>
<%@ include file="../include/footer.jsp"%>		