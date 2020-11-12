package com.example.authenticatingldap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {
    	logger.info("Called index");
        return "Welcome to the home page!";
    }

    @GetMapping("/hello")
    public String hello()
//			throws Exception
    {
    	logger.info("Called hello");
//		throw new Exception();
        return "Hello developer!";
    }

    @GetMapping("/managers")
    public String managers() {
    	logger.info("Called managers");
        return "Hello manager!";
    }

    @GetMapping("/user")
    public String user(Authentication authentication) {
    	logger.info("Called user");
        System.out.println(authentication.getAuthorities());
        return authentication.getName();
    }
}
