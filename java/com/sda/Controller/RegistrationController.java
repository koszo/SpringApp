package com.sda.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RegistrationController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {

		return "login";
	}

	@RequestMapping(value = "/successfulLogin")
	public String loginSuccessful() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> userRoles = (List<GrantedAuthority>) authentication.getAuthorities();
    	
        for(GrantedAuthority x: userRoles) {
        
        if(x.getAuthority().equalsIgnoreCase("role_admin")){
        	return "redirect:/region/list";
        }else if (x.getAuthority().equalsIgnoreCase("role_client")) {
			
		return "redirect:/country/list";
        }
        }
        return "accessDenied";
        
	}

	@RequestMapping(value = "/failedlogin")
	public String loginFailed(ModelMap model) {

		String errorMessage = "Incorrect username or password.";
		model.addAttribute("errorMessage", errorMessage);

		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logoutPage() {

		return "login";
	}
}
