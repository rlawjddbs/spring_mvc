<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- SmartMenu 시작 -->
<link
	href="http://localhost:8080/mybatis_prj/common/smartmenu/css/sm-core-css.css"
	rel="stylesheet" type="text/css" />

<link
	href="http://localhost:8080/mybatis_prj/common/smartmenu/css/sm-simple/sm-simple.css"
	rel="stylesheet" type="text/css" />

<!-- jQuery -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

<!-- SmartMenus jQuery plugin -->
<script type="text/javascript"
	src="http://localhost:8080/mybatis_prj/common/smartmenu/jquery.smartmenus.min.js"></script>

<!-- SmartMenus jQuery init -->
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX : 1,
			subMenusSubOffsetY : -8
		}); // smartmenus
		
	}); // ready 
	
	function sendPost(){
		// Chrome은 JavaScript에서 action을 변경하면 form의 action이
		// 계속 유지된다.
		document.hidFrm.action="http://localhost:8080/spring_mvc/request_post.do";
		document.hidFrm.submit();
	} // sendPost
	
	function requestAll(){
		var method="";
		if(confirm("GET방식으로 요청하시겠습니까?")){
			method="GET";
		} else {
			alert("POST 방식으로 요청합니다.");
			method="POST";
		} // end else 
		document.hidFrm.method=method;
		document.hidFrm.action="http://localhost:8080/spring_mvc/request_all.do";
		document.hidFrm.submit();
	} // requestAll
	
	function requestString(){
		var url = "request_string.do";
		if( confirm("문자열의 매개변수를 전송 하시겠습니까?") ){
			url += "?name=jungyun";
		} // end if
		location.href="http://localhost:8080/spring_mvc/"+url;
	} // requestString
	
	function requestInt(){
		var url = "request_int.do";
		if( confirm("정수형의 매개변수를 전송 하시겠습니까?") ){
			url += "?age=20";
		} // end if
		location.href="http://localhost:8080/spring_mvc/"+url;
	} // requestString
	
</script>
<form action="request_post.do" name="hidFrm" id="hidFrm" method="post"></form>
<nav id="main-nav">
	<!-- Sample menu definition -->
	<ul id="main-menu" class="sm sm-simple">
		<li><a href="http://localhost:8080/spring_mvc/index.html">홈으로</a></li>
		<li><a href="#void">Spring MVC 사용</a>
			<ul>
				<li><a href="#void">1일차</a>
					<ul>
						<li><a href="http://localhost:8080/spring_mvc/request_get.do">GET 방식 요청</a></li>
						<li><a href="#void" onclick="sendPost()">POST 방식 요청</a></li>
						<li><a href="#void" onclick="requestAll()">GET/POST 모두 요청</a></li>
						<li><a href="request_form.do">HttpServletRequest로 파라메터 처리</a></li>
						<li><a href="vo_form.do">VO로 파라메터 처리</a></li>
					</ul>
				</li>
				<li><a href="#void">2일차</a>
					<ul>
						<li><a href="#void" onclick="requestString()">단일 데이터형 처리(문자열)</a></li>
						<li><a href="#void" onclick="requestInt()">단일 데이터형 처리(정수형)</a></li>
						<li><a href="http://localhost:8080/spring_mvc/view_request.do">HttpServletRequest사용 데이터전달</a></li>
						<li><a href="http://localhost:8080/spring_mvc/view_model.do">Model 사용 데이터전달</a></li>
						<li><a href="http://localhost:8080/spring_mvc/view_modelandview.do">Model And View 사용 데이터전달</a></li>
						<li><a href="http://localhost:8080/spring_mvc/use_redirect.do">redirect를 사용한 페이지 이동</a></li>
					</ul>
				</li>
				<li><a href="#void">3일차</a>
					<ul>
						<li><a href="http://localhost:8080/spring_mvc/session/use_session.do">HttpSession 사용</a></li>
						<li><a href="http://localhost:8080/spring_mvc/session/an_use_session.do">@SessionAttributes(Annotation) 사용</a></li>
					</ul>
				</li>
				<li><a href="#void">4일차</a>
					<ul>
						<li><a href="http://localhost:8080/spring_mvc/cookie/read_cookie.do">Cookie클래스를 사용한 값 얻기</a></li>
						<li><a href="http://localhost:8080/spring_mvc/cookie/an_read_cookie.do">@CookiValue(Annotation)를 사용한 쿠키값 얻기</a></li>
						<li><a href="http://localhost:8080/spring_mvc/include/include.do">JSP include 하기</a></li>
						<li><a href="http://localhost:8080/spring_mvc/ajax/ajax.do">Spring AJAX</a></li>
					</ul>
				</li>
				<li><a href="#void">5일차</a>
					<ul>
						<li><a href="http://localhost:8080/spring_mvc/diary/list.do">일정보기</a></li>
					</ul>
				</li>
				<li><a href="#void">6일차</a>
					<ul>
						<li><a href="http://localhost:8080/spring_mvc/exception/exception.do">Controller에서 예외처리</a></li>
						<li><a href="http://localhost:8080/spring_mvc/chain/chain_a.do">a.do 요청</a></li>
						<li><a href="http://localhost:8080/spring_mvc/chain/chain_b.do">b.do 요청</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="#">동기방식 차량조회</a></li>
	</ul>
</nav>
<!-- SmartMenu 끝 -->