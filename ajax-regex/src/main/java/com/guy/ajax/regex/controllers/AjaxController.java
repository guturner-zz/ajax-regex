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
		System.out.println(regex + ", " + txt);
		
		RegexResult result = new RegexResult();
		
//		String r = txt;
//		
//		Matcher m = null;
//		try {
//			Pattern p = Pattern.compile(regex);
//			m = p.matcher(txt);
//		} catch (Exception e) {
//			
//		}
//		
//		while (m != null && m.find()) {
//			String match = m.group();
//			r = r.replace(match, "<span class='hilight'>" + match + "</span>");
//		}
		
		try {
			result.setResult(txt.replaceAll("(" + regex + ")", "<span class='hilight'>$1</span>"));
		} catch (Exception e) {
			System.out.println(e);
			result.setResult(txt);
		}
		
		System.out.println(result.getResult());
		
		return result;
    }
	
}
