package com.karson.webmagic;
 

import java.security.Principal;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextListener;
 

@SpringBootApplication()
@EnableOAuth2Sso
@RestController
public class WebmagicApplication  {
	 
	public static void main(String[] args) {
		SpringApplication.run(WebmagicApplication.class, args);
	}
	@RequestMapping("/client")
	public String home(Principal user) {
		
		return "Hello " + user.getName();
		
	} 
	@RequestMapping("/getsession")
	public String getsession(HttpServletRequest request,  HttpServletResponse response) {
		HttpSession session = request.getSession();
		Enumeration<String> list=session.getAttributeNames();
 		while(list.hasMoreElements()){ 
 			   System.out.println("name:"+list.nextElement()+"    value:"+session.getAttribute(list.nextElement())); 
 		}
		 for (Cookie cookie : request.getCookies()) {
			   System.out.println(cookie.getName()+" "+cookie.getValue());
		 }
		 Cookie myCookie1 =new Cookie("JSESSIONID", "");
		// Cookie myCookie2 =new Cookie("UISESSION", "");
				  response.addCookie(myCookie1);
			//	  response.addCookie(myCookie2);
		return null;
		
	} 

}
