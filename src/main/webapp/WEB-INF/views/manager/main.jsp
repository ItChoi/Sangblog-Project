<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<html>
<head>
	<title>메인 페이지</title>
	<link href="../resources/css/home.css" rel="stylesheet" type="text/css">
	
</head>
<body>
 <a href="/manager/logout" >로그아웃</a>
	<div class="wrap">	
		<%@ include file="../header.jsp" %>
		<div class="content_wrap">
			<!-- <div class="content_login">
				나의 개인블로그 ! 메인 메뉴를 뭘로 할까
				introduce를 메인으로 할까 아니면 따로 심플한 메인을 만들까.
				<div class="login_frame_header">
					Login 로그인
				</div>
				<div class="login_frame_content">
					<div>
						<div class="li_bl" style="width: 200px;">
							<div class="li_bl" style="width: 30px; margin-top: 20px;">
								<label>ID</label>
							</div>
							<input type="text"> <br/>
	
							<div class="li_bl" style="width: 30px;">
								<label>PW</label>
							</div>
							<input type="password"> 
						</div>
						<div class="li_bl" style="width: 70px;">
							<button class="btn_login" style="height: 50px;">로그인</button>
						</div>	
					</div>
							<button class="btn_style btn_register">회원가입</button>
							<button class="btn_style btn_nonmember">비회원으로 보기</button>
					<div>
						<a href="">아이디 찾기</a>
						<a href="">비밀번호 찾기</a>
						<a href="member_register" class="member_register">회원가입</a>
					</div>
				</div>
				<div class="login_frame_bottom">
					나중에 네이버 로그인 카톡 로그인 등등 해보자.
				</div>
			</div> -->
			
			<div class="content_register">
				<div class="register_frame_header">
					회원가입 
				</div>
				<div class="register_frame_content">
					<form id="formInfo">
						<input class="register_form" type="file" name="file">
						
						<input class="id register_form required" type="text" name="id" title="아이디" placeholder="아이디 입력...">
						<input class="password register_form required" type="password" name="password" title="비밀번호" placeholder="비밀번호 입력...">
						<input class="password1 register_form required" type="password" title="비밀번호" placeholder="비밀번호  재입력...">
	
						<input class="name register_form required" type="text" title="이름" placeholder="이름  입력...">
						<input class="phone register_form" type="text" placeholder="핸드폰 번호 입력...">
						<input class="email register_form" type="text" placeholder="이메일 번호 입력...">
						<input class="job_and_school register_form" type="text" placeholder="직업 또는 학교 입력...">
						
						<br/><input class="terms" type="checkbox"> <a href="">이용약관</a>에 동의합니다.
					</form>
				</div>
				<div class="register_frame_bottom">
					<button class="btn_style" onclick="memberRegister()">회원가입</button>
					<button class="member_cancel btn_style">가입 취소</button>
					
				</div>
				
			
			</div>
			
			
		</div>
		
	</div>
	
	<script type="text/javascript">
	
		var $id = $('.id');
		var $password = $('.password');
		var $password1 = $('.password1');
		var $name = $('.name');
		var $jobAndSchool = $('.job_and_school');
		var $terms = $('.terms');
		
		$(document).ready(function() {
			$('.btn_register').on('click', function() {
				location.href = "register";
			});
			
			$('.member_register, .member_cancel').on('click', function() {
				event.preventDefault();
				if($('.content_login').css('display') == 'block') {
					$('.content_login').css('display', 'none');
					$('.content_register').css('display', 'block');
				} else {
					$('.content_login').css('display', 'block');
					$('.content_register').css('display', 'none');
				}
				
			});
			
			
			
		});
		
		function memberRegister() {
			validator();
			location.href = "";
			
		}
		
		function validator() {
			var statusCheck = true;
			var formInfo = $('#formInfo');
			formInfo.children().each(function() {
				if($(this).hasClass('required')) {
					if($(this).val() == '') {
						alert($(this).attr('title') + " 을 입력하셔야 됩니다 고갱님");
						$(this).focus();
						statusCheck = false;
						return false;
					}
				}
				$(this).textLength;
				
			});
			
			if(statusCheck != false) {
				if($terms.is(':checked') == false) {
					alert('약관에 동의를 하셔야죠 고갱님');
					return false;
				}
			}
			
		}
		
	</script>
	
</body>
</html>
