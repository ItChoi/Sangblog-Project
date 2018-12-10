package ver2.blog.sang.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class UserUtils {
// 클래스 이름 알맞게 고칠 필요....
	
	// Session을 통해 loginId를 불러 올 때 각 메소드 마다 HttpSession을 파라미터로 심는 것을 절약하기 위함.
	public static String getLoginId() {
		
		HttpSession session = getHttpSession();
		 String loginId = (String) session.getAttribute("loginId");
		 
		return loginId;
	}
	public static void setLoginId(String loginId) {
		
		HttpSession session = getHttpSession();
		session.setAttribute("loginId", loginId);
	}
	private static HttpSession getHttpSession() {
		// 강제로 HttpServletRequest 객체 가져오는 법?
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest(); 
		
		// request.isUserInRole("")
		
		HttpSession session = request.getSession();
		
		return session;
	}
	
}
