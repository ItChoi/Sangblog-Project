package ver2.blog.sang.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class authController {
	/*private static final Logger logger = LoggerFactory.getLogger(authController.class);
	
	@RequestMapping(value="/manager/main", method=RequestMethod.GET)
	public ModelAndView login(@RequestParam(value="error", required = false) String error,
							  @RequestParam(value="logout", required =false) String logout) {
		ModelAndView model = new ModelAndView();
		
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.setViewName("/manager/main");
		
		
		return model;
	}*/
	
}
