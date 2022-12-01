package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import model.PostData;
import model.StartUpBrowser;

@Controller
public class ResultController {
	@GetMapping("/result")
	public ModelAndView DataInput(ModelAndView mav,HttpServletRequest request) {
		HttpSession session = request.getSession();
		PostData pd = (PostData) session.getAttribute("pd");
		try {
			StartUpBrowser sub = new StartUpBrowser(pd);		
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return mav;
	}
}
