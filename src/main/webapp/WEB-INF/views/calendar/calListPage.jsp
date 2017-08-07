<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/cal/css/fullcalendar.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/cal/css/jquery-ui.min.css"/>
<script src="${pageContext.request.contextPath}/resources/cal/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/cal/js/moment.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/cal/js/fullcalendar.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/cal/js/locale-all.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/cal/js/jquery-ui.min.js" type="text/javascript"></script>


<div id="calendar"></div>

 <script>
 $(function(){
	 calendarEvent();
 })
 function calendarEvent(eventData){
	 $("#calendar").html("");
	 var date = new Date();
	 var d = date.getDate();
	 var m = date.getMonth();
	 var y = date.getFullYear();
	  $("#calendar").fullCalendar({
		 hearder:{
			 left:"",
			 center:"title",
			 right:"today prev,next",
		 },
		 editable:true,
		 titleFormat:{
			 month:"yyyy년 MMMM",
			 week:"[yyyy]MMM dd일{[yyyy]MMM dd일}",
			 day: "yyyy년 MMM d일 dddd"
		 },
		 allDayDefault:false,
		 defaultView:"month",
		 editable: false,
		 monthNames:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
		 monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		 dayNames:["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
		 dayNamesShort:["일","월","화","수","목","금","토"],
		 buttonText:{
			 today:"오늘",
			 month:"월별",
			 week:"주별",
			 day:"일별"
		 },
		 /* event: eventData, */
		 timeFormat:"HH:mm"
	 })
 }
	/* $(function() {
		$(document).ready(function(){
			var date = new Date();
			var d = date.getDate();
			var m = date.getMonth();
			var y = date.getFullYear();
			$("#calendar").fullCalendar({
				header:{
					left:"prev,next today",
					center : "title",
					right:"month,agendaWeek,agendDay"
				},
				titleFormat:{
					month: "yyyy년 MMMM",
					week: "yyyy년 MMMM d[yyyy]{'일~'[MMM]dd일}",
					day: 'yyyy년 MMMM d dddd'
				},
				columnFormat:{
					month: "ddd",
					week: "M/d ddd",
					day: "M월 d일 dddd"
				},
				 timeFormat:{
					": 'HH:mm', 
					agenda: 'HH:mm{-HH:mm}'
				}, 
				allDayText:"시간",
				axjsFormat:"tt hh",
				
				monthNames:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
				monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				dayNames:["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
				dayNamesShort:["일","월","화","수","목","금","토"]
				 selectable:true,
				selectHelper: true, 
			})
		})
	}) */
</script>
<%@ include file="../include/footer.jsp"%>
</body>