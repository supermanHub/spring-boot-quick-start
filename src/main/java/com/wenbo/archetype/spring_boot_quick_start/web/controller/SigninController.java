package com.wenbo.archetype.spring_boot_quick_start.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/signin")
public class SigninController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signin() {
		return new ModelAndView("signin");
	}
}
