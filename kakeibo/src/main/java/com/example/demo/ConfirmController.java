package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import model.CategoryNames;
import model.PostData;

@Controller
public class ConfirmController {
	
	@PostMapping("/confirm")
	public ModelAndView getPost(@ModelAttribute PostData pd,ModelAndView mav,HttpServletRequest request) {
		System.out.println();
		if(pd.getDate().equals("")) {
			String error = "日付が未入力です";
			CategoryNames cn = new CategoryNames();
			mav.setViewName("redirect:");
			mav.addObject("c", cn);
			mav.addObject(error);
			System.out.println("Date = null");
			return mav;
		}else {
		HttpSession session = request.getSession();
		pd.addData();
		pd.replaceDate();
		session.setAttribute("pd", pd);
		mav.setViewName("confirm");
		mav.addObject("pd",pd);
		return mav;
		}
	}
	
}
