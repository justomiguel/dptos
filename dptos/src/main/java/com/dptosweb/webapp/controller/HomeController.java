package com.dptosweb.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.dptosweb.model.ciudades.Departamento;
import com.dptosweb.model.ciudades.Localidad;
import com.dptosweb.model.ciudades.Provincia;
import com.dptosweb.service.DepartamentoManager;
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
	
	@Autowired
	DepartamentoManager departamentoManager;
	
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
		
		for (Departamento dpto: departamentoManager.getDepartamentos()) {
			data.add(new Tag(cont++, dpto.getNombre()));
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

	@ModelAttribute("operationType")
	public Map getOperationType() {
		Map<String,String> cOperationType = new LinkedHashMap<String,String>();
		cOperationType.put("Co", "Comprar");
		cOperationType.put("Al", "Alquilar");
		return cOperationType;
	}
	
	@ModelAttribute("propertyType")
	public Map getPropertyTypes() {
		Map<String,String> propertyTypes = new LinkedHashMap<String,String>();
		propertyTypes.put("Co", "Cochera");
		propertyTypes.put("Dpto", "Departamento");
		propertyTypes.put("Ca", "Casa");
		return propertyTypes;
	}
	
	@ModelAttribute("roomCount")
	public Map getRootCount() {
		Map<Integer,String> country = new LinkedHashMap<Integer,String>();
		for (int i = 1; i < 6; i++) {
			country.put(i, i+((i>1)?" Habitaciones":" Habitacion"));
		}
		
		return country;
	}
	
	@ModelAttribute
	@RequestMapping(value = "/home*", method = RequestMethod.GET)
	public HomeSearch showForm() {
		HomeSearch search = new HomeSearch();
		return search;
	}

	@RequestMapping(value = "/home*", method = RequestMethod.POST)
	public String onSubmit(HomeSearch homeSearch, BindingResult errors,
			HttpServletRequest request) throws Exception {
		
		if (validator != null) { // validator is null during testing
            validator.validate(homeSearch, errors);

            if (errors.hasErrors()) {
                return "home";
            }
        }
		return getSuccessView();
	}
}
