package com.example.authenticatingldap;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Swagger description annotations
@RestController
@RequestMapping("/home")
@Api(value = "welcomehome")
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    @ApiOperation(value = "Get home message")
    public String index() {
        logger.info("Called index");
        return "Welcome to the home page!";
    }

    @GetMapping("/hello")
    @ApiOperation(value = "Say hello!")
    public String hello()
//			throws Exception
    {
        logger.info("Called hello");
//		throw new Exception();
        return "Hello developer!";
    }

    @GetMapping("/managers")
    @ApiOperation(value = "Managerial secrets")
    public String managers() {
        logger.info("Called managers");
        return "Hello manager!";
    }

    @GetMapping("/user")
    @ApiOperation(value = "Get who you are")
    public String user(Authentication authentication) {
        logger.info("Called user");
        System.out.println(authentication.getAuthorities());
        return authentication.getName();
    }
}
