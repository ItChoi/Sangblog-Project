package ver2.blog.sang.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import ver2.blog.sang.utils.UserUtils;

public class ManagerLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(ManagerLoginSuccessHandler.class);
	
	private String targetUrlParameter;
	private String defaultUrl;
	private boolean useReferer;

	public ManagerLoginSuccessHandler() {
		targetUrlParameter = "";
		defaultUrl = "";
		useReferer = false;
	}
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	
	public String getTargetUrlParameter() {
		return targetUrlParameter;
	}
	public void setTargetUrlParameter(String targetUrlParameter) {
		this.targetUrlParameter = targetUrlParameter;
	}
	public String getDefaultUrl() {
		return defaultUrl;
	}
	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}
	public boolean isUseReferer() {
		return useReferer;
	}
	public void setUseReferer(boolean useReferer) {
		this.useReferer = useReferer;
	}

	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		logger.info("ManagerLoginSuccessHandler 성공, 회원 정보: " + auth.getPrincipal());
		
		System.out.println("test:::::::" + auth.getName());
		HttpSession session = req.getSession();
		session.setAttribute("loginId", auth.getName());
		
		// 로그인 post로 가기 전 여기로 와서 session 설정 해줘야 하는데 에러 발생
		// UserUtils.setLoginId(auth.getName());
		
		clearAuthenticationAttributes(req);
		
		int intRedirectStrategy = decideRedirectStrategy(req, res);
		
		System.out.println("도대체 몇 나오냐? : " + intRedirectStrategy);
		switch(intRedirectStrategy) {
		case 1:
			useTargetUrl(req, res);
			break;
		
		case 2:
			useSessionUrl(req, res);
			break;
		
		case 3:
			useRefererUrl(req, res);
			break;
		default :
			useDefaultUrl(req, res);
		}
		
	}
	
	private void clearAuthenticationAttributes(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			return;
		}
		
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	
	private void useTargetUrl(HttpServletRequest req, HttpServletResponse res) throws IOException {
		SavedRequest savedRequest = requestCache.getRequest(req, res);
		
		if (savedRequest != null) {
			requestCache.removeRequest(req, res);
		}
		
		String targetUrl = req.getParameter(targetUrlParameter);
		redirectStrategy.sendRedirect(req, res, targetUrl);
		
	}
	
	private void useSessionUrl(HttpServletRequest req, HttpServletResponse res) throws IOException {
		SavedRequest savedRequest = requestCache.getRequest(req, res);
		
		String targetUrl = savedRequest.getRedirectUrl();
		
		redirectStrategy.sendRedirect(req, res, targetUrl);
	}

	private void useRefererUrl(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String targetUrl = req.getHeader("REFERER");
		
		redirectStrategy.sendRedirect(req, res, targetUrl);
	}
	
	private void useDefaultUrl(HttpServletRequest req, HttpServletResponse res) throws IOException {
		redirectStrategy.sendRedirect(req, res, defaultUrl);
	}
	
	/**
	 * 인증 성공후 어떤 URL로 redirect 할지를 결정한다.
	 * 판단 기준은 targetUrlParameter 값을 읽은 URL이 존재할 경우 그것을 1순위
	 * 1순위 URL이 없을 경우 Spring Security가 세션에 저장한 URL을 2순위
	 * 2순위 URL이 없을 경우 Request의 REFERER를 사용하고 그 REFERER URL이 존재할 경우 그 URL을 3순위
	 * 3순위 URL이 없을 경우 Default URL을 4순위로 한다.
	 * 
	 * @param request
	 * @param response
	 * @return	1. targetUrlParamter 값을 읽은 URL
	 * 			2. Session에 저장되어 있는 URL
	 * 			3. referer 헤더에 있는 url
	 * 			0. default url
	 */
	private int decideRedirectStrategy(HttpServletRequest req, HttpServletResponse res) {
		
		int result = 0;
		
		SavedRequest savedRequest = requestCache.getRequest(req, res);
		
		System.out.println("savedRequest: " + savedRequest);
		
		if (!"".equals(targetUrlParameter)) {
			String targetUrl = req.getParameter(targetUrlParameter);
			
			if (StringUtils.hasText(targetUrl)) {
				result = 1;
			} else {
				if (savedRequest != null) {
					result = 2;
				} else {
					String refererUrl = req.getHeader("REFERER");
					
					if (useReferer && StringUtils.hasText(refererUrl)) {
						result = 3;
					} else {
						result = 0;
					}
				}
			}
			
			return result;
		}
		
		if (savedRequest != null) {
			result = 2;
			return result;
		}
	
		String refererUrl = req.getHeader("REFERER");
		
		if (useReferer && StringUtils.hasText(refererUrl)) {
			result = 3;
		} else {
			result = 0;
		}
		
		return result;
	}
	
	
	
}
