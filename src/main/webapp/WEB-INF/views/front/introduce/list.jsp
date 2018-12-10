<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<html>
<head>
	<title>메인 페이지</title>
	<link href="../resources/css/home.css" rel="stylesheet" type="text/css">
	
</head>
<body>
	<div class="wrap">	
		
		<%@ include file="/WEB-INF/views/header.jsp" %>
			
		<div class="content_wrap">
			<div class="content">
				<form:form path="managerInfo">
					<div class="simple_introduce">
						<div class="picture_frame">
							<!-- 사진 불러오기 ${managerInfo} -->
							<img alt="시바견 시바" src="/../resources/images/dog.jpg" style="height: 158px; width: 158px;">
						</div> 
						<div class="simple_introduction">
							${managerInfoParam.introduce }
						</div>
					</div>
					
					<div class="btn_test">
						<div class="btn_1">
							<button>사진 수정</button>
						</div>
						<div class="btn_2">
							<button>내용 수정</button>
						</div>						
						
					</div>
					
				<!-- forEach로 자격 정보 있는 것 불러오기. insert는 따로 -->
				<h3>자격증</h3><hr/>
				<c:forEach var="certificate" items="${managerCertificateParam }">
					<div class="my_certificate">
						<div class="get_year">
							${certificate.getYear }
						</div>
						<div class="certificate_name">
							${certificate.certificateName }
						</div>
					</div>
				</c:forEach>
					
				<h3>경력</h3><hr/>
					<c:forEach var="experience" items="${managerExperienceParam }">
						<div class="my_experience">
							<div class="work_year">
								${experience.workYear }
							</div>
							<div class="company">
								${experience.company }
							</div>
							<div class="work_detail">
								${experience.workDetail }
							</div>
						</div>
					</c:forEach>
					
					
					
					<div class="insert_experience">
						<input type="text" name="year" class="insert_year">
						<input type="text" name="company" class="insert_company">
						<input type="text" name="work_detail" class="insert_work_detail">
					</div>
	
					<div class="btn_check1" style="width: 100%; text-align: center; padding: 10px; clear: both;">
						<button class="btn_insert_cancel">추가</button>
					</div>
					<div class="btn_check2" style="width: 100%; text-align: center; padding: 10px; clear: both; display: none;">
						<button class="btn_enter">입력</button>
						<button class="btn_insert_cancel">취소</button>
					</div>
				
				
				
				</form:form>
				
			</div>
				
		</div>
		
	</div>
	
<script type="text/javascript">
	$(document).ready(function() {
		$('.btn_insert_cancel').on('click', function() {
			event.preventDefault();
			// jQuery 변수
			$box_view = $('.insert_experience');
			$btn_plus = $('.btn_check1');
			$btn_insert_cancel = $('.btn_check2');
			
			if ($box_view.css('display') == 'none') {
				$box_view.css('display', 'block');
				$btn_insert_cancel.css('display', 'block');
				$btn_plus.css('display', 'none');	
			} else {
				$('.insert_year').val('');
				$('.insert_company').val('');
				$('.insert_work_detail').val('');	
				
				$box_view.css('display', 'none');
				$btn_insert_cancel.css('display', 'none');
				$btn_plus.css('display', 'block');
			}
			
		});	
	});
</script>
	
</body>
</html>
