package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
//	private AuthenticationService authenticationService;
//	
//	public WelcomeController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

//	private Logger logger = LoggerFactory.getLogger(getClass());
//	@RequestMapping(value="login", method=RequestMethod.GET)
//	public String gotoLoginPage() {
//		return "login";
//	}
	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			model.put("password", password);
//			return "welcome";
//		}
//		
//		model.put("errorMessage", "Invalid Credential");
//		return "login";
//	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUsername());
		return "welcome";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
