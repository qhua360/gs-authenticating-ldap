package com.example.authenticatingldap;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Welcome to the home page!";
	}

	@GetMapping("/hello")
	public String hello()
//			throws Exception
	{
//		throw new Exception();
		return "Hello developer!";
	}

	@GetMapping("/managers")
	public String managers() {
		return "Hello manager!";
	}

	@GetMapping("/user")
	public String user(Authentication authentication) {
		System.out.println(authentication.getAuthorities());
		return authentication.getName();
	}
}
