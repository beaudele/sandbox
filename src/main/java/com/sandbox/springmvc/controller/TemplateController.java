package com.sandbox.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class TemplateController.
 */
@Controller
public class TemplateController {

  /**
   * Gets the user registration form template.
   *
   * @return the user registration form template
   */
  @RequestMapping(value = "/user_registration_form")
  public String getUserRegistrationFormTemplate() {
    return "template/partial-user_registration_form";
  }

  /**
   * Gets the user edit template.
   *
   * @param id the id
   * @return the user edit template
   */
  @RequestMapping(value = "/user_edit/{id}")
  public String getUserEditTemplate(@PathVariable("id") long id) {
    return "template/partial-user_edit";
  }

  /**
   * Gets the user list template.
   *
   * @return the user list template
   */
  @RequestMapping(value = "/user_list")
  public String getUserListTemplate() {
    return "template/partial-user_list";
  }

}
