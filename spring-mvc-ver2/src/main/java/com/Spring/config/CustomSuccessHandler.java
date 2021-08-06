package com.Spring.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		  Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
          UserDetails userdetail = (UserDetails) authentication.getPrincipal();
          String username = userdetail.getUsername();
          String password = userdetail.getPassword();
          System.out.println("login "+ username +" password = "+ password);
          
    
	        if (roles.contains("ROLE_ADMIN")) {
	            response.sendRedirect("admin/success");
	        } else {
	            response.sendRedirect("user/homepage");
	        }
	}

}
