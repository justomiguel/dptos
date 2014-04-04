package com.dptosweb.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dptosweb.webapp.controller.forms.HomeSearch;

@Controller
@RequestMapping("/home*")
public class HomeController extends BaseFormController {

	public HomeController() {
		setCancelView("redirect:/home");
		setSuccessView("uploadDisplay");
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public HomeSearch showForm() {
		HomeSearch search = new HomeSearch();
		//search.setLocationToSearch("test for Jona");
		return search;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(FileUpload fileUpload, BindingResult errors,
			HttpServletRequest request) throws Exception {

		
		return getSuccessView();
	}
}
