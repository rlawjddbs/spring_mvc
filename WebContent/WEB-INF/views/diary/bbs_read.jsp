<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc/common/css/main_v190130.css" />
<style type="text/css">
	#wrap{ margin: 0px auto; width:800px; height:auto;  }
	#header{ mwidth:800px; height:140px; background:#FFF url('http://localhost:8080/spring_mvc/common/images/header_bg.png'); position:relative; }
	#headerTitle{ font-family: HY견고딕, 고딕; font-size: 35px; font-weight:bold; text-align:center; position:absolute; left:300px; top:30px; }
	#container{ width:800px; }
	#footer{ width:800px; height:120px; }
	#footerTitle{ float:right; font-size:15px; padding-top:20px; padding-right: 20px;}
	#reply{ display:none; padding:20px; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#replyView").click(function(){
			var txt = $("#replyView").text();
			if(txt == "댓글 열기"){
				$("#replyView").text("댓글 접기")
			} else {
				$("#replyView").text("댓글 열기")
			} // end else
			$("#reply").slideToggle(300);
		});
		
		$(".btn").click(function(){
			var writer = $("[name='writer']").val();
			if( writer == "" ){
				alert("작성자는 필수 입력!!!");
				$("[name='writer']").focus();
				return;
			} // end if
			var reply = $("[name='reply']").val();
			if( reply == "" ){
				alert("내용은  필수 입력!!!");
				$("[name='reply']").focus();
				return;
			} // end if
			
			var queryString="num_ref="+$("[name='num_ref']").val()+"&content="+reply+"&writer="+writer; 
			$.ajax({
				url:"add_reply.do",
				data:queryString,
				type:"get",
				dataType:"json",
				error:function(xhr){
					alert("댓글 작성 실패");
					console.log(xhr.status+" / "+xhr.statusText);
				}, // error
				success:function( json ){
					if( json.result ){
						// <div>의 자식 노드로 작성한 값을 추가(append)
						// 자식 노드 전에 추가 (prepend())
						var date=new Date();
						var output = '<div style="box-shadow:0 0 15px rgba(0, 0, 0, 0.5); width:600px; padding:15px; margin:10px 0; border-radius:15px">'+
						reply+"<br />"+writer+"("+date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"</div>";						
						
						$("#reply").prepend(output);
						$("[name='writer']").val("");
						$("[name='reply']").val("");
						
						alert("댓글이 정상적으로 등록되었습니다.");
					} // end if
				} // success
			}); // AJAX
			
		}); // click
		
	}); // ready
</script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
			<div style="padding-top:100px;">
				<c:import url="/common/jsp/main_menu.jsp" />
			</div>
		</div>
		<div id="container">
			
		<div id="readFrm">
		<input type="hidden" name="pageFlag" />
		<input type="hidden" name="num" value="${ param.num }"/>
		<input type="hidden" name="param_year" value="${ param.param_year }" />
		<input type="hidden" name="param_month" value="${ param.param_month}" />
		<table id="readTab">
			<tr>
				<th colspan="2">
					<span style="font-size:20px ">이벤트 읽기</span>
				</th>
			</tr>
			<tr>
				<td style="width:80px;">제목</td>
				<td style="width:400px;">
					<div id="subject">
						<strong>${ searchData.subject}</strong>
					</div>
				</td>
			</tr>
			<tr>
				<td style="width:80px;">내용</td>
				<td style="width:400px;">
					${ searchData.contents}
				</td>
			</tr>
			<tr>
				<td style="width:80px;">이벤트 일</td>
				<td style="width:400px;">
					<div id="evtDate">${ param.param_year } - ${ param.param_month } - ${ param.param_day } </div>
				</td>
			</tr>
			<tr>
				<td style="width:80px;">작성자</td>
				<td style="width:400px;">
					<div id="writer"><strong>${ searchData.writer}</strong></div>
				</td>
			</tr>
			<tr>
				<td style="width:80px;">작성일</td>
				<div id="wDate"><strong>${ searchData.w_date}</strong></div>
				</td>
			</tr>
			<tr>
				<td style="width:80px;">작성IP</td>
				<td style="width:400px;">
					<div id="ip"><strong>${ searchData.ip}</strong></div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="#void" onclick="history.back()">글 목록으로</a>
				</td>
			</tr>
		</table>
		<table border="0">
			<tr>
				<td style="width:80px">댓글</td>
				<td><input type="text" class="inputBox" name="reply" style="width:400px"/>
				<input type="text" class="inputBox" name="writer" placeholder="작성자" />
				<input type="button" class="btn" value="댓글등록" /></td>
				<input type="hidden" name="num_ref" value="${ param.num }" />
			</tr>
		</table>
		<div style="margin:10px 0"><a href="#void" id="replyView">댓글 열기</a></div>
		<div id="reply">
			<c:forEach var="reply" items="${ replyList }">
				<div style="box-shadow:0 0 15px rgba(0, 0, 0, 0.5); width:600px; padding:15px; margin:10px 0; border-radius:15px">
					<strong><c:out value="${ reply.writer }" /></strong><br />
					<c:out value="${ reply.content }" /> ( <c:out value="${ reply.input_date }" /> )
				</div>
			</c:forEach>
		</div>
</div>
			
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserve class 4</div>
		</div>
	</div>
</body>
</html>