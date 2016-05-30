package com.guy.ajax.regex.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guy.ajax.regex.beans.RegexResult;

@Controller
public class AjaxController {

	@RequestMapping("/regex/search")
    public @ResponseBody RegexResult searchAPI(@RequestParam(value="regex", required=true) String regex, @RequestParam(value="txt", required=true) String txt) {
		RegexResult result = new RegexResult();
		
		System.out.println(regex + " " + txt);
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(txt);
		
		if (m.matches()) {
			result.setResult("Found a match!");
		} else {
			result.setResult("No match.");
		}
		
		System.out.println(result.getResult());
		
		return result;
    }
	
}
