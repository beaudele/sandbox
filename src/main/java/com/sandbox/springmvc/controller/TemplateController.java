package com.sandbox.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

	@RequestMapping(value = "/user_registration_form")
	public String getUserRegistrationFormTemplate() {
		return "template/partial-user_registration_form";
	}

	@RequestMapping(value = "/user_edit/{id}")
	public String getUserEditTemplate(@PathVariable("id") long id) {
		return "template/partial-user_edit";
	}
	
	@RequestMapping(value = "/user_list")
	public String getUserListTemplate() {
		return "template/partial-user_list";
	}

}