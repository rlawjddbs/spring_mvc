<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_mvc/common/css/main_v190130.css" />
<style type="text/css">
	#wrap{ margin: 0px auto; width:800px; height:860px;  }
	#header{ mwidth:800px; height:140px; background:#FFF url('http://localhost:8080/spring_mvc/common/images/header_bg.png'); position:relative; }
	#headerTitle{ font-family: HY견고딕, 고딕; font-size: 35px; font-weight:bold; text-align:center; position:absolute; left:300px; top:30px; }
	#container{ width:800px; }
	#footer{ width:800px; height:120px; }
	#footerTitle{ float:right; font-size:15px; padding-top:20px; padding-right: 20px;}
	/* td{ padding:10px; } */
	#subject { padding-top:10px; }
	#subject > a { padding-left:10px; padding-right:10px; color:blue; font-weight:bold; transition-duration:0.3s; }
	#subject > a:hover { text-decoration:none; color:#A3CB38; }
	
	#wrap{ margin: 0px auto; width:800px; height:860px;  }
	#header{ mwidth:800px; height:140px; background:#FFF url('http://localhost:8080/jsp_prj/common/images/header_bg.png'); position:relative; }
	#headerTitle{ font-family: HY견고딕, 고딕; font-size: 35px; font-weight:bold; text-align:center; position:absolute; left:300px; top:30px; }
	#container{ width:800px; }
	#footer{ width:800px; height:120px; }
	#footerTitle{ float:right; font-size:15px; padding-top:20px; padding-right: 20px;}
	
	#diary{ margin-top:20px; }
	#diaryHeader{ font-size:19px; font-weight:bold; text-align:center; padding:5px 0 20px 0; }
	#diaryContents{ min-height:400px; }
	#diaryIndexList{ height:30px; text-align:center; }
	
	
	#diarySearch{ height:30px; text-align:center; }
	
	#listTab{ border-top:2px solid #1289A7; border-spacing:0px; }
	#numTitle{ width:50px; height:25px; background-color:#12CBC4; color:#fff; }
	#subjectTitle{ width:350px;; height:25px; background-color:#12CBC4; color:#fff; }
	#writerTitle{ width:120px; height:25px; background-color:#12CBC4; color:#fff; }
	#evtDayTitle{ width:150px; height:25px; background-color:#12CBC4; color:#fff; }
	#wriDayTitle{ width:150px; height:25px; background-color:#12CBC4; color:#fff; }
	th, td{ border-bottom: 1px solid #ccc; }
	tr:HOVER{ background-color:#f8f8f8; }
	
	.center{ text-align:center; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
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
			<div id="diary">
				<div id="diaryHeader">
					<span style="float:left"><a href="list.jsp"><img src="images/btn_all.png" /></a></span>
					이벤트 리스트
				</div>
				<div id="diaryContent" style="height:500px;">
					<table id="listTab">
						<tr>
							<th id="numTitle" >번호</th>
							<th id="subjectTitle">이벤트 제목</th>
							<th id="writerTitle">작성자</th>
							<th id="evtDayTitle">이벤트 일자</th>
							<th id="wriDayTitle">작성 일자</th>
						</tr>
						<c:if test="${ not empty e }">
							<tr>
								<td colspan="5">서비스가 원활하지 못한 점 죄송합니다.</td>
							</tr>
						</c:if>
						<c:if test="${ empty diaryList }">
							<tr>
								<td colspan="5">이벤트가 존재하지 않습니다.<a href="diary.jsp"><br />이벤트 작성</a></td>
							</tr>
						</c:if>
						<c:forEach var="data" items="${ diaryList }">
							<c:set var="i" value="${ i + 1 }" />
							<tr>
								<%-- <td class="center"><c:out value="${ i }" /></td> --%>
								<td class="center"><c:out value="${ (totalCount - (currentPage-1)*pageScale-i)+1 }" /></td>
								<td><a href="bbs_read.do?num=${ data.num }"><c:out value="${ data.subject }" /></a></td>
								<td class="center"><c:out value="${ data.writer }" /></td>
								<td class="center"><c:out value="${ data.e_year }-${ data.e_month }-${ data.e_day }" /></td>
								<td class="center"><c:out value="${ data.w_date }" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				
				<div id="diaryIndexList" style="text-align:center;">
					<%-- <c:forEach var="i" begin="1" end="${ totalPage }" step="1">
						[ <a href="list.jsp?current_page=${ i }">${ i }</a> ]
					</c:forEach> --%>
					<!-- escapeXml="false" 은 c:out으로 태그를 출력할 때 -->
					<c:out value="${ indexList }" escapeXml="false" />
				</div>
			<div id="view">
				
			</div>
			<div>
			</div>
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserve class 4</div>
		</div>
	</div>
</body>
</html>