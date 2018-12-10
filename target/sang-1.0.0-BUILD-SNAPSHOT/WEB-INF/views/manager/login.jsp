<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<link href="../resources/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="content_wrap">
	<div class="content_login">
	<!-- 				나의 개인블로그 ! 메인 메뉴를 뭘로 할까 -->
	<!-- 				introduce를 메인으로 할까 아니면 따로 심플한 메인을 만들까. -->
		<div class="login_frame_header">
			Login 로그인 
		</div>
		<div class="login_frame_content">
<!-- 			<form id="loginForm" action="login" method="post"> -->
			<!-- <form id="loginForm" name="loginForm" action="/j_spring_security_check" method="POST"> -->
			<form id="loginForm" name="loginForm" action="/login" method="POST">
				<%--csrf 사용 X (SSL 관련) --%>
				<%-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" /> --%>
				<div>
					<div class="li_bl" style="width: 200px;">
						<div class="li_bl" style="width: 30px; margin-top: 20px;">
							<label for="loginId">ID</label>
						</div>
						<!-- <input type="text" name="loginId" id="loginId"> <br/> -->
						<input type="text" name="loginId" id="loginId"> <br/>
		
						<div class="li_bl" style="width: 30px;">
							<label for="password">PW</label>
						</div>
						<input type="password" name="password" id="password"> 
					</div>
					<div class="li_bl" style="width: 70px;">
						<button class="btn_login" style="height: 50px;">로그인</button>
						<!-- security 로그인 자체 로그인 검증 서비스 이용하기. -->
						<!-- <button class="btn_login" style="height: 50px;" onclick="return passwordCheck();">로그인</button> -->
					</div>	
					<%-- <c:if test="${not empty param.fail }">
						<p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }</p>
						<c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>
					</c:if> --%>
						
				</div>
			</form>
			<!-- <button class="btn_style btn_register">회원가입</button> -->
			<!-- <button class="btn_style btn_nonmember">비회원으로 보기</button> -->
			<div>
				<a href="">아이디 찾기</a>
				<a href="">비밀번호 찾기</a>
				<a href="member_register" class="member_register">회원가입</a>
			</div>
		</div>
		<div class="login_frame_bottom">
			나중에 네이버 로그인 카톡 로그인 등등 해보자.
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
	// var loginId = '${loginId}';
	var exceptionMsg = '${exceptionMsg}';

	if (exceptionMsg != '') {
		alert('로그인 정보를 제대로 입력해주세요.');
		location.href = "/manager/login"; 
	}
	
	
	/* if (loginId != '') {
		alert('입력한 아이디가 존재하지 않습니다.');
	} else {
		alert(exceptionMsg);
	} */
	
	
	/* alert('${fail}');
	if ('${fail}' != null) {
		alert('로그인 후 매니저 페이지를 사용해주세요.');
	} */
	
});

	/* function passwordCheck() {
		alert('asdasd');
		var $loginId = $('#loginId').val();
		var $inputPassword = $('#password').val();
	
		$.ajax({
			type: 'post',
			url: '/manager/enc-password-check',
			data: {
				inputPassword: $inputPassword,
				loginId: $loginId
			},
			success: function(response) {
				alert('캬캬캬캬캬캬캬컄ㅋ');
				if (response == true) {
					// 로그인 성공
					alert('로그인성공인데');
					$('#loginForm').submit();
				} else {
					// 로그인 실패
					alert('로그인 실패했쨔냐....');
				}
			}
		});
		
		alert('nnnㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ');
		return false;
		
	} */

	
</script>
<body>

</html>

