package ver2.blog.sang.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import ver2.blog.sang.domain.ManagerInfo;

public class ManagerLoginFailureHandler implements AuthenticationFailureHandler {

	// loginId 값이 들어오는 input 태그 name
	private String loginIdName = "loginId";
	// password 값이 들어오는 input 태그 name
	private String loginPasswordName = "password";
	// 로그인 성공시 redirect 할 URL이 지정되어 있는 input 태그 name
	private String loginRedirectName = "loginRedirect";
	// 예외 메시지를 request의 Attribute에 저장할 때 사용될 key 값
	private String exceptionMsg = "securityExceptionMsg";
	// 화면에 보여줄 URL(로그인 화면)
	private String defaultFailureUrl = "/manager/login";
	
	
	public String getLoginIdName() {
		return loginIdName;
	}

	public void setLoginIdName(String loginIdName) {
		this.loginIdName = loginIdName;
	}

	public String getLoginPasswordName() {
		return loginPasswordName;
	}

	public void setLoginPasswordName(String loginPasswordName) {
		this.loginPasswordName = loginPasswordName;
	}

	public String getLoginRedirectName() {
		return loginRedirectName;
	}

	public void setLoginRedirectName(String loginRedirectName) {
		this.loginRedirectName = loginRedirectName;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	
	
	/*public ManagerLoginFailureHandler() {
		System.out.println("생성@@@@@@@@@@@@");
		System.out.println("생성@@@@@@@@@@@@");
		System.out.println("생성@@@@@@@@@@@@");
		this.loginIdName = "loginId";
		this.loginPasswordName = "password";
		this.loginRedirectName = "loginRedirect";
		this.exceptionMsg = "securityExceptionMsg";
		this.defaultFailureUrl = "/manager/login";
	}*/
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException exception)
			throws IOException, ServletException {
		// System.out.println("1: " + req.getUserPrincipal()); // 로그인 아이디
		// System.out.println("2: " + req.getAuthType()); // ROLE
		// System.out.println("3: " + exception.getMessage()); // 에러 메시지
		// ManagerLoginFailureHandler failure = new ManagerLoginFailureHandler();

		System.out.println("실패 : onAuthenticationFailure");
		
		String loginId = req.getParameter(loginIdName);
		String password = req.getParameter(loginPasswordName);
		String loginRedirect = req.getParameter(loginRedirectName);
		
		
		req.setAttribute("loginId", loginId);
		req.setAttribute("password", password);
		// req.setAttribute(loginRedirectName, loginRedirect);
		// Request 객체의 Attribute에 예외 메시지 저장
		req.setAttribute("exceptionMsg", exception.getMessage());
		
		req.getRequestDispatcher(defaultFailureUrl).forward(req, res);
		
		// jsp에 추가.... http://zgundam.tistory.com/53
		
	}
	
}
