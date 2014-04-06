package com.dptosweb.webapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dptosweb.model.Tag;
import com.dptosweb.model.ciudades.Localidad;
import com.dptosweb.model.ciudades.Provincia;
import com.dptosweb.service.LocalidadManager;
import com.dptosweb.service.ProvinciaManager;
import com.dptosweb.service.UserManager;
import com.dptosweb.webapp.controller.forms.HomeSearch;

@Controller
public class HomeController extends BaseFormController {
	
	@Autowired
	ProvinciaManager provinciasManager;

	@Autowired
	LocalidadManager localidadesManager;
	
	public HomeController() {
		setCancelView("redirect:/home");
		setSuccessView("uploadDisplay");
	}
	
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	@ResponseBody
	public List<Tag> getTags(@RequestParam String tagName) {
		int cont = 0;
		List<Tag> data = new ArrayList<Tag>();
		List<Tag> result = new ArrayList<Tag>();
		
		for (Provincia pcias : provinciasManager.getProvincias()) {
			data.add(new Tag(cont++, pcias.getNombre()));
		}
		
		for (Localidad localidades : localidadesManager.getLocalidades()) {
			data.add(new Tag(cont++, localidades.getNombre()));
		}
		// iterate a list and filter by tagName
		  for (Tag tag : data) {
			if (tag.getTagName().toLowerCase().startsWith(tagName.toLowerCase())) {
				result.add(tag);
			}
		}
		return result;
	}

	@ModelAttribute("mainPlaceHolder")
	public String getMainPlaceHolder() {
		return getText("homeSearch.locationToSearchPlaceHolder", Locale.getDefault());
	}
	
	@ModelAttribute
	@RequestMapping(value = "/home*", method = RequestMethod.GET)
	public HomeSearch showForm() {
		HomeSearch search = new HomeSearch();
		return search;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(FileUpload fileUpload, BindingResult errors,
			HttpServletRequest request) throws Exception {

		return getSuccessView();
	}
}
