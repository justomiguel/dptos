package com.dptosweb.webapp.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dptosweb.webapp.controller.forms.HomeSearch;



public class SearchValidator implements Validator{
	
	public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "locationToSearch", "homeSearch.locationEmpty");
    }

	@Override
	public boolean supports(Class<?> arg0) {
		return HomeSearch.class.isAssignableFrom(arg0);
	}

}
