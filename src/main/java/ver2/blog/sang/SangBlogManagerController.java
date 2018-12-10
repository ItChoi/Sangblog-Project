package ver2.blog.sang;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ver2.blog.sang.domain.ManagerCertificate;
import ver2.blog.sang.domain.ManagerExperience;
import ver2.blog.sang.domain.ManagerInfo;
import ver2.blog.sang.service.ManagerService;
import ver2.blog.sang.utils.UserUtils;

@RequestMapping("/manager")
@Controller
public class SangBlogManagerController {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired ManagerService managerService;
	
	
	
	@RequestMapping(value={"/"}, method=RequestMethod.GET)
	public String managerMain() {
		System.out.println("아에오오오옹");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		/*System.out.println("메인 GET1::: " + auth.getName());
		System.out.println("메인 GET2::: " + auth.getAuthorities());
		System.out.println("메인 GET3::: " + auth.getPrincipal());
		System.out.println("메인 GET4::: " + auth.getCredentials());
		System.out.println("메인 GET5::: " + auth.getDetails());*/
		
		
		return "/manager/main";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGet(String error, String exceptionMsg, String securityExceptionMsg, HttpServletRequest req) {
		/*System.out.println("loginGET0: " + exceptionMsg);
		System.out.println("loginGET1: " + securityExceptionMsg);
		System.out.println("loginGET2: " + req.getParameter("securityExceptionMsg"));
		System.out.println("loginGET3: " + req.getParameter("exceptionTest"));
		System.out.println("loginGET4: " + req.getParameter("exceptionMsg"));
		System.out.println("loginGET5: " + req.getParameter("loginId"));*/
		
		
		if (error != "" && error != null) {
			System.out.println("에러 발생: " + error);
		} else {
			System.out.println("에러 안발생");
		}
		
		// System.out.println("설마 1");
		// 로그인 안하고 메인 페이지 갔을 때 fail의 값 fail !
		// model.addAttribute("fail", fail);
		
	}
	
	// 시큐리티에서 로그인 처리를 하기 떄문에 loginPost는 필요없다.
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void loginPost(String loginId, String securityExceptionMsg, HttpServletRequest req) {
		System.out.println("loginPost");
		// loginPost 할 것이 아니라, SuccessHandler 에서 Session 관리 
		// UserUtils.setLoginId(loginId);
		
		// 메소드 get에 보내짐
		// return "redirect:/manager/"; 
	}
	
	// security.xml 에서 세션 초기화 및 JESSIONID 쿠키 remove
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public void Logout() {
		System.out.println("여기는 로그아웃 입니다.");
		//  ???
		// 1. 시큐리티에서 session 초기화
		// 2. 시큐리티 설정에서 로그아웃 성공시 url 정의
		// 
	}
	
	@RequestMapping(value={"/introduce"}, method=RequestMethod.GET)
	public String managerIntroduce(@ModelAttribute("managerInfo") ManagerInfo managerInfo, Model model) {
		
		ManagerInfo managerInfoParam = managerService.getManagerInfoByLoginId(UserUtils.getLoginId());
		// ManagerInfo managerInfoParam = managerService.getManagerInfo();
		
		int managerId = managerInfoParam.getManagerId();
		
		managerInfoParam.setPhoneNumberLabel(managerInfoParam.getPhoneNumber());
		
		model.addAttribute("managerCertificateParam", managerService.getManagerCertificateByManagerId(managerId));
		model.addAttribute("managerExperienceParam", managerService.getManagerExperienceByManagerId(managerId));
		model.addAttribute("managerInfoParam", managerInfoParam);
		
		return "/manager/introduce/list";
	}
	
	@PostMapping(value="/introduce")
	public String managerIntroduce(ManagerInfo managerInfo, MultipartFile file,
			ManagerCertificate certificate, ManagerExperience experience, HttpServletRequest request
			) {
		
		if (!"".equals(managerInfo.getPassword())) {
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encPassword = passwordEncoder.encode(managerInfo.getPassword());
			managerInfo.setPassword(encPassword);
		}

		String uploadPath = "";
		String fileName = "";
		
		fileName = file.getOriginalFilename();
		managerInfo.setImageName(fileName);
		
		System.out.println("fileName: " + fileName);
		
		if (fileName != null && !"".equals(fileName)) {
			
			try {
				uploadPath = getSaveLocation(request, managerInfo);
				// 파일 이름 제외한 업로드 경로 저장
				
				managerInfo.setImageSrc(uploadPath + File.separator);
				
				System.out.println("파일 업로드 경로1: " + uploadPath);
				File uploadDirectory = new File(uploadPath);
				
				File fileUpload = new File(uploadPath 
											+ File.separator
											+ managerInfo.getImageName());
				
				System.out.println("파일 업로드 경로2: " + fileUpload);
				
				// 경로 + 이미지가 존재하는지 확인한다.
				if (fileUpload.exists()) {
					// 존재 - 파일 삭제하고 새로 업로드(아이디에 프로필은 1개로 지정)
					if (fileUpload.delete()) {
						// 삭제 성공
						FileCopyUtils.copy(managerInfo.getFile().getBytes(), fileUpload);
						
					} else {
						// 삭제 실패
						System.out.println("@@@@@파일 삭제 실패@@@@@");
					}
				} else {
					// 업로드 경로에 해당 파일이 존재하지 않을
					if (!uploadDirectory.exists()) {
						uploadDirectory.mkdirs();
					}
					
					FileCopyUtils.copy(managerInfo.getFile().getBytes(), fileUpload);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		managerService.updateManagerInfo(managerInfo);
		
		return "redirect:/manager/introduce";
	}
	
	
	@ResponseBody
	@RequestMapping("enc-password-check")
	public ResponseEntity<Boolean> passwordCheck(String inputPassword, String loginId) {
		
		System.out.println("비밀번호 체크");
		
		boolean isSuccess = false;
		
		isSuccess = passwordCoincidence(inputPassword, loginId);
		
		ResponseEntity<Boolean> entity = new ResponseEntity<>(isSuccess, HttpStatus.OK);
		
		return entity;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="insert-spec", method=RequestMethod.POST)
	public ResponseEntity<ManagerInfo> inserSpec(ManagerInfo managerInfo,
			ManagerCertificate certificate, ManagerExperience experience) {

		
		if (certificate.getGetYear() != null && certificate.getCertificateName() != null) {
			managerInfo.setManagerCertificate(certificate);
		}
		
		if (experience.getWorkYear() != null && experience.getCompany() != null && experience.getWorkDetail() != null) {
			managerInfo.setManagerExperience(experience);
		}

		managerService.insertSpec(managerInfo);
		
		
		ResponseEntity<ManagerInfo> entity = new ResponseEntity<>(managerInfo, HttpStatus.OK);
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="delete-spec", method=RequestMethod.POST)
	public ResponseEntity<Integer> deleteSpec(int specId, String type) {
		int result = 0;
		
		if (specId != 0) {
			result = managerService.deleteSpec(specId, type);
		}
		
		ResponseEntity<Integer> entity = new ResponseEntity<>(result, HttpStatus.OK);
		return entity;
	}
	
	
	// TODO:: 비즈니스 로직 따로 서비스 단에 빼기.
	private String getSaveLocation(HttpServletRequest request, ManagerInfo managerInfo) {
		
		String absolutPath = request.getSession().getServletContext().getRealPath("/resources"); // 서버열었을 때 이 경로로 하기.
		// String absolutPath = File.separator + "resources";
		String uploadPath = "upload" + File.separator + managerInfo.getLoginId() 
							+ File.separator  + managerInfo.getManagerId();
		
		return absolutPath + File.separator + uploadPath;
	}
	
	
	// 암호화된 비밀번호 비교 - 로그인, 암호 수정 등에 쓰기 위해 메소드로...
	private boolean passwordCoincidence(String inputPassword, String loginId) {
	
		boolean isSuccess = false;
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		// TODO:: comparePassword 변수 사용
		String comparePassword = passwordEncoder.encode(inputPassword);

		String tempPassword = managerService.getPasswordByLoginId(loginId);
		
		if (passwordEncoder.matches(inputPassword, tempPassword)) {
			isSuccess = true;
		} else {
			isSuccess = false;
		}
		
		return isSuccess;
	}
		
}

