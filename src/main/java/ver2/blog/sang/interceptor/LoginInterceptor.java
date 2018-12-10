package ver2.blog.sang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("흠 여기오려나???????????????? 인터셉터");
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		
		// 세션 아이디가 없을 때 
		if (loginId == null || loginId == "") {
			response.sendRedirect("/manager/login");
			/*RequestDispatcher rd = request.getRequestDispatcher("/manager/login");
			rd.forward(request, response);*/
			
			return false;
		} else {
			// 세션 아이디가 존재할 때 가고자 하는 url 이동 가능하도록 true
			return true;
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
