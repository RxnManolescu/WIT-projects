package com.roxana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.roxana.model.service.GreetingService;

@Controller
public class GreetingController {

	@Autowired
	private GreetingService greetingService;
	
	
	@RequestMapping("/eve")
	public ModelAndView myEveningController() {
		ModelAndView modelAndView = new ModelAndView();
		String greetMessage = greetingService.evening();
		modelAndView.addObject("message", greetMessage);
		modelAndView.setViewName("Greet");
		
		return modelAndView;
	}
	
	@RequestMapping("/mrng")
	public ModelAndView myMorningController() {
		ModelAndView modelAndView = new ModelAndView();
		String greetMessage = greetingService.morning();
		modelAndView.addObject("message", greetMessage);
		modelAndView.setViewName("Greet");
		
		return modelAndView;
	}
}
