/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.controller;

import com.example.demo.model.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

/**
 * <p>
 * <code>WebController</code>
 * </p>
 * Description: This controller has a GET and a POST method, both mapped to /
 *
 * @author Mcchu
 * @date 2018/4/11 9:26
 */
@Controller
public class WebController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	/**
	 * The showForm method returns the form template
	 * It includes a PersonForm in its method signature
	 * so the template can associate form attributes with a PersonForm
	 *
	 * @param personForm 关联属性实体
	 * @return form template
	 */
	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	/**
	 * Check Method For Test
	 *
	 * @param personForm personForm object marked up with @Valid to gather the attributes
	 *    filled out in the form you’re about to build
	 * @param bindingResult bindingResult object so you can test for and retrieve validation errors.
	 * @return result
	 */
	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		return "redirect:/results";
	}
}
