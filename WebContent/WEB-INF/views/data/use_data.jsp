<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		info="Controller에서 HttpServletRequest를 사용하여 전달된 값을 처리하는 Page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/srping_mvc/common/css/main_v190130.css" />
<style type="text/css">
	#wrap{ margin: 0px auto; width:800px; height:860px;  }
	#header{ mwidth:800px; height:140px; background:#FFF url('http://localhost:8080/srping_mvc/common/images/header_bg.png'); position:relative; }
	#headerTitle{ font-family: HY견고딕, 고딕; font-size: 35px; font-weight:bold; text-align:center; position:absolute; left:300px; top:30px; }
	#container{ width:800px; }
	#footer{ width:800px; height:120px; }
	#footerTitle{ float:right; font-size:15px; padding-top:20px; padding-right: 20px;}
	/* td{ padding:10px; } */
	#subject { padding-top:10px; }
	#subject > a { padding-left:10px; padding-right:10px; color:blue; font-weight:bold; transition-duration:0.3s; }
	#subject > a:hover { text-decoration:none; color:#A3CB38; }
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
		<div id="container" style="overflow:hidden;">
			<div>값을 전달한 객체 : <c:out value="${ msg }"/></div>
			<div style="width: 300px; height:300px; padding:20px 0; box-sizing:border-box; float:right; background-image:url(http://localhost:8080/spring_mvc/common/images/postit.png);">
				<div style="margin-top:30px; margin-left:25px; overflow:hidden;">
					<ul>
						<li style="font-weight:bold; list-style:none">공지사항</li>
						<c:forEach var="notice" items="${ requestScope.req_data }">
							<li>
								<a href="notice_detail.do?num=${ notice.num }"><c:out value="${ notice.subject }" /></a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserve class 4</div>
		</div>
	</div>
</body>
</html>