package com.guy.ajax.regex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegexController {
	
	@RequestMapping("/")
    public String regexHome() {
        return "regexHome";
    }
	
}