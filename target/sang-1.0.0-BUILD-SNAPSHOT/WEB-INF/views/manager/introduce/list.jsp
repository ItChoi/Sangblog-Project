<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<html>
<head>
	<title>메인 페이지</title>
	<link href="../resources/css/sangblog.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/manager/introduce.css" rel="stylesheet" type="text/css">
	
</head>
<body>
		
	<%@ include file="/WEB-INF/views/header.jsp" %>
	<div class="wrap">
		<div class="content_wrap">
			<div class="content">
				
				<div class="content_frame">
					<div class="login_frame">
				 
						<form:form path="managerInfo" commandName="managerInfo" method="post" enctype="multipart/form-data">
							<form:hidden path="managerId" value="${managerInfoParam.managerId }"/>
							<%-- <input type="hidden" id="tempPassword" name="tempPassword" value="${managerInfoParam.password }"/> --%>
							
							
							<table>
								<colgroup>
									<col width="200px" style="background: gray;"/>
									<col width="350px" />
								</colgroup>
								
								<tbody>
									<tr>
										<td>
											<label for="loginId">아이디</label>
										</td>
										 
										<td>
											<form:input path="loginId" title="아이디" class="input_frame" value="${managerInfoParam.loginId }" readonly="true" />
										</td>
									</tr>
								
									<tr>
										<td>
											<label for="password">비밀번호</label>
										</td>
										<td>
											<input id="password" type="password" />
											<input type="button" id="password_change_btn" value="비밀번호 변경">
										</td>
									</tr>


									<tr class="new_password none">
										<td>
											<label for="password1">새 비밀번호</label>
										</td>
										<td>
											<input type="password" placeholder="새 비밀번호 입력" id="password1" class="input_frame" />
										</td>
									</tr>
									
									<tr class="new_password none">
										<td>
											<label for="password2">새 비밀번호</label>
										</td>
										<td>
											<input name="password" id="password2" type="password" placeholder="새 비밀번호 입력" id="password2" class="input_frame" />
											<input type="button" id="password_cancel_btn" value="비밀번호 변경 취소">
										</td>
									</tr>


									
									<tr>
										<td>
											<label for="name">이름</label>
										</td>
										<td>
											<form:input path="name" type="text" class="input_frame" value="${managerInfoParam.name }"/>
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="phoneNumber1">핸드폰번호</label>
										</td>
										<td>
											<div class="phone_frame">
												<form:input path="phoneNumber" type="hidden"/>
												<select id="phoneNumber1" name="phoneNumber1">
													<option value="010">010</option>
													<option value="011">011</option>
													<option value="016">016</option>
													<option value="019">019</option>
												</select>
												<input type="text" id="phoneNumber2" value="${managerInfoParam.phoneNumber2 }"/>
												<input type="text" id="phoneNumber3" value="${managerInfoParam.phoneNumber3 }"/>
											</div>
										</td>
									</tr> 
									<tr>
										<td>
											<label for="password">이메일</label>
										</td>
										<td>
											<div class="email_frame">
												<form:input path="email" type="hidden" />
												<input type="text" id="email1"/>
												@
												<input type="text" id="email2"/>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<label for="file">사진</label>
										</td>
										<td>
											<input type="file" id="file" name="file" style="display: none;"/>
											<form:input path="imageName" value="${managerInfoParam.imageName}" />
											<button type="button" id="fileSelect">파일선택</button> 
										</td>
									</tr>
									
									<tr>
										<td></td>
										<td>
											<img id="profile" alt="프로필사진" src="${managerInfoParam.imageSrc }${managerInfoParam.imageName}" >
										</td>									
									</tr>
									
									<tr>
										<td>
											<label for="introduce">간단 소개</label>
										</td>
										<td>
											<textarea name="introduce" id="introduce" class="textarea_frame">${managerInfoParam.introduce }</textarea>
											
										</td>
									</tr>
									
								</tbody>
							</table>
							
							
							<h3>자격정보</h3>
							<hr/>
							
							<c:forEach var="certificate" items="${managerCertificateParam }">
								<div class="certificate_frame valueOn">
									<div class="getYear ib">
										${certificate.getYear }
									</div> 
									<div class="certificateName ib">
										${certificate.certificateName }
									</div>
									<button type="button" value="${certificate.certificateId }" class="DeleteListSpec fr" onclick="DeleteListSpec($(this));">X</button>
								</div>
							</c:forEach>
							
							<div class="add_certificate_frame">
 
							</div>
							<div class="add_certificate_frame_copy" >
								<div class="certificate_box valueOff">
									<input name="getYear" type="text" class="getYear required" title="년도" placeholder="년도"/>
									<input name="certificateName" type="text" class="certificateName required" title="자격증명" placeholder="자격증명"/>
									<button type="button" class="DeleteListSpec fr" onclick="DeleteListSpec($(this))" style="margin: 2px; height: 22px;">X</button>
								</div>
							</div>
							
							<div class="add_certificate">
								<input type="button" id="plus_certificate" class="plus" value="추가" title="자격증"/>
							</div>
							
							
							<h3>경력정보</h3>
							<hr/>
							<c:forEach var="experience" items="${managerExperienceParam }">
								<div class="experience_frame valueOn">
									<div class="workYear ib">
										${experience.workYear }
									</div>
									<div class="company ib">
										${experience.company }
									</div>
									<button type="button" value="${experience.experienceId }" class="DeleteListSpec fr" onclick="DeleteListSpec($(this));" >X</button>
									
									<div class="workDetail">
										${experience.workDetail }
									</div>
								</div>
							</c:forEach>
							<div class="add_experience_frame">

							</div>
							
							<div class="add_experience_frame_copy">
								<!-- <div class="workYear ib"> 
									<input name="workYear" type="text" class="workYear required" placeholder="다닌 년도" title="다닌 년도" />
								</div>
								<div class="company ib">
									<input name="company" type="text" class="company required" placeholder="다닌 회사명" title="다닌 회사명" />
								</div>
								<div class="workDetail">
									<textarea name="workDetail" class="workDetail" rows="3"  placeholder="회사 상세 업무" title="회사 상세 업무" ></textarea>
								</div> -->
								<div class="experience_box valueOff">
									<input name="workYear" type="text" class="workYear required" placeholder="다닌 년도" title="다닌 년도" />
									<input name="company" type="text" class="company required" placeholder="다닌 회사명" title="다닌 회사명" />
									<button type="button" value="${experience.experienceId }" class="DeleteListSpec fr" onclick="DeleteListSpec($(this));" >X</button>
									<textarea name="workDetail" class="workDetail required" rows="3"  placeholder="회사 상세 업무" title="회사 상세 업무" ></textarea>
								</div><br/>
								
							</div>
							
							
							
							<div class="add_experience">
								<input type="button" id="plus_experience" class="plus" value="추가" title="경력" />
							</div>
							
							<div class="info_submit">
								<input type="submit" value="저장" onclick="return validator();" />
								<input type="button" value="취소" />
							</div>
							
						</form:form>
										
					</div>
					
					
				</div>
				
			</div>
		</div>
	</div>
	
<script type="text/javascript">

	var $cerCopy = $('.add_certificate_frame_copy');
	var $expCopy = $('.add_experience_frame_copy');
	
	$(document).ready(function() {
		var isSuccess = true;
		
		var $firstPhoneNum = "${managerInfoParam.phoneNumber1}";
		var emailFullName = "${managerInfoParam.email}";
		
		var $email1 = $('#email1'); 
		$email1.val(emailFullName.substring(0, emailFullName.lastIndexOf("@")));
		
		
		var $email2 = $('#email2');
		$email2.val(emailFullName.substring(emailFullName.lastIndexOf("@") + 1));
		
		
		$('#phoneNumber1 option').val($firstPhoneNum).attr("selected", "selected");
		
		
		$('.plus').on('click', function() {
			var list = '';
			
			if ($(this).attr('title') == '자격증') {
				/* list = $('.add_certificate_frame_copy').html(); */
				list = $cerCopy.html();
				$('.add_certificate_frame').append(list);
			} else if ($(this).attr('title') == '경력') {
				list = $expCopy.html();
				$('.add_experience_frame').append(list);
			}
			
		});
		
		/* alert('test');
		$('#password_change_btn').on('click', function() {
			alert('test');
			var $password = $('#password');
			var $password1 = $('#password1');
			var $password2 = $('#password2');
			alert('test');
			
		}); */
		
	});
	
	function validator() {
		
		isSuccess = true;
		
		
		// 이상없이 submit이 되면 복사본 삭제하여 데이터 전달
		$cerCopy.remove(); 
		$expCopy.remove();  
		

		var inputBox = $('input[type="text"]');
		
		
		// required 클래스가 추가되면 필수 입력! 
		inputBox.each(function() {
			if ($(this).hasClass('required')) {
				var title = $(this).attr('title');
				if ($(this).val() == '') {
					alert(title + " 을 입력하셔야 됩니다 고갱님");
					$(this).focus();
					isSuccess = false;
					return false;
				} else {
					isSuccess = true;
				}
			}
		});
		
		if (!isSuccess) {
			return false;
		}
		
		var $password1 = $('#password1');
		var $password2 = $('#password2');
		
		if (($password1.val() != '' && $password2.val() != '') || $('.new_password').hasClass('none') == true) {
			if ($password1.val() == $password2.val()) {
				isSuccess = true;
			} else {
				alert('새 비밀번호 입력을 일치시켜주세요.');
				isSuccess = false;
				false;
			}
			
		} else {
			alert('새 비밀번호를 입력해주세요.');
			isSuccess = false;
			false;
		}
		
		
		var sizeCertificate = $('.add_certificate_frame > .certificate_box').length;
		var sizeExperience = $('.add_experience_frame > .experience_box').length;
				
		insertCertificateAndExperience(sizeCertificate, sizeExperience);

		if (!isSuccess) {
			return false;
		}
		
		
		return true;
		
	}
	
	
	$('#password_change_btn').on('click', function() {
		
		var $inputPassword = $('#password').val();
		var $loginId = $('#loginId').val();
		
		if ($inputPassword != '') {
			
			$.ajax({
				type: 'post',
				url: "/manager/enc-password-check",
				data: {
					inputPassword: $inputPassword,
					loginId: $loginId
					// tempPassword: $('#tempPassword').val()
				},
				success: function(response) {
					if (response) {
						// 비밀번호 변경 창 보여주기
						$('.new_password').removeClass('none');
					} else {
						alert('비밀번호를 다시 확인해주세요.')
						$('.new_password').addClass('none'); 
						$('#password1').val('');
						$('#password2').val('');
					} 
				} 
			}); 
		}
	});
	
	$('#password_cancel_btn').on('click', function() {
		$('.new_password').addClass('none'); 
		$('#password1').val('');
		$('#password2').val('');
	});
	
	function insertCertificateAndExperience(sizeCertificate, sizeExperience) {
		if (sizeCertificate == 0 && sizeExperience == 0) {
			return;
		} else {
			
			if (isSuccess == false) {
				return false;
			}
			
			if (sizeCertificate > 0) {
				$('.certificate_box').each(function(i) {
					$.ajax({
						type : "post",
						url : "/manager/insert-spec",
						data: {
							getYear : $(this).children().eq(0).val(),
							certificateName : $(this).children().eq(1).val(),
							managerId : $('#managerId').val()
						},
						success: function(response) {
							alert(response.managerCertificate.certificateName + " 자격증을 추가했습니다.");
						}
					});
					
				});
					
			}
			
			if (sizeExperience > 0) {
				$('.experience_box').each(function(i) {
					$.ajax({
						type : "post",
						url : "/manager/insert-spec",
						data: {
							workYear : $(this).children().eq(0).val(),
							company : $(this).children().eq(1).val(),
							workDetail : $(this).children().eq(3).val(),
							managerId: $('#managerId').val()
						},
						success: function(response) {
							alert(response.managerExperience.company + "경력을 추가했습니다.");
						}
					});
				});
				
			}
		}
	}

	function DeleteListSpec(that) {
		
		var type = that.parent().attr('class');
		var specType = type.substring(0, type.lastIndexOf("_"));
		
		if (that.parent().hasClass('valueOn')) {
			if (confirm("삭제하실래요?")) {
				$.ajax({
					type: "post",
					url: "/manager/delete-spec",
					data: {
						specId : that.val(),
						type : specType
						
					},
					success: function(response) {
						if (response == 1) {
							that.parent().remove();
						} else {
							alert('삭제 실패...');
						}
					}
				});
			}
		}
		
		if (that.parent().hasClass('valueOff')) {
			that.parent().remove();
		}
	}

	// file 커스터마이징
	$("#fileSelect").on('click', function() {
		$('#file').click();
	});
	
	$('#file').on('change', function() {
		// TODO::
	});
	
	
</script>
	
</body>
</html>
