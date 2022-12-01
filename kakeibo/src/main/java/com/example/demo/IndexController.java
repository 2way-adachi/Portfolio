package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import model.CategoryNames;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		CategoryNames cn = new CategoryNames();
		mav.setViewName("/index");
		mav.addObject("c",cn);
		return mav;
	}
}