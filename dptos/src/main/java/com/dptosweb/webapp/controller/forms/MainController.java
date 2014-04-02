package com.dptosweb.webapp.controller.forms;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.dptosweb.model.Tag;
 
@Controller
public class MainController {
 
	List<Tag> data = new ArrayList<Tag>();
 
	MainController() {
		// init data for testing
		data.add(new Tag(1, "Buenos Aires"));
		data.add(new Tag(2, "C�rdoba"));
		data.add(new Tag(3, "Rosario"));
		data.add(new Tag(4, "Mendoza"));
		data.add(new Tag(5, "La Plata"));
		data.add(new Tag(6, "San Miguel de Tucum�n	"));
		data.add(new Tag(7, "Santa Fe"));
		data.add(new Tag(8, "Mar del Plata"));
		data.add(new Tag(9, "Salta"));
		data.add(new Tag(10, "San Juan"));
		data.add(new Tag(11, "Avia Terai"));
		data.add(new Tag(12, "Charata"));
		data.add(new Tag(13, "El Sauzalito"));
		data.add(new Tag(14, "Fuerte Esperanza"));
		data.add(new Tag(15, "Gancedo"));
		data.add(new Tag(16, "General Pinedo"));
		data.add(new Tag(17, "General San Martin"));
		data.add(new Tag(18, "General Vedia"));
		data.add(new Tag(19, "Hermoso Campo"));
		data.add(new Tag(20, "Isla del Cerrito"));
		data.add(new Tag(21, "Juan Jose Castelli"));
		data.add(new Tag(22, "Las Bre�as"));
		data.add(new Tag(23, "Machagai"));
		data.add(new Tag(24, "Mision Nueva Pompeya"));
		data.add(new Tag(25, "Pampa del Indio"));
		data.add(new Tag(26, "Puerto Tirol"));
		data.add(new Tag(27, "Resistencia"));
		data.add(new Tag(28, "Roque Saenz Pe�a"));
		data.add(new Tag(29, "Villa Angela"));
		data.add(new Tag(30, "Villa Rio Bermejito"));
		data.add(new Tag(31, "Clorinda"));
		data.add(new Tag(32, "El Colorado"));
		data.add(new Tag(33, "Formosa Capital"));
		data.add(new Tag(34, "General Manuel Belgrano"));
		data.add(new Tag(35, "Herradura"));
		data.add(new Tag(36, "Ibarreta"));
		data.add(new Tag(37, "Ingeniero Juarez"));
		data.add(new Tag(38, "Laguna Blanca"));
		data.add(new Tag(39, "Las Lomitas"));
		data.add(new Tag(40, "Mayor Villafa�e"));
		data.add(new Tag(41, "Palo Santo"));
		data.add(new Tag(42, "Pirane"));
		data.add(new Tag(43, "San Francisco de Laishi"));
		data.add(new Tag(44, "Riacho He He"));
		data.add(new Tag(45, "Corrientes Capital"));
		data.add(new Tag(46, "Goya"));
		data.add(new Tag(47, "Mercedes Corrientes"));
		data.add(new Tag(48, "Paso de la Patria"));
		data.add(new Tag(49, "Santa Ana"));
		data.add(new Tag(50, "Virasoro"));

	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPages() {
 
		ModelAndView model = new ModelAndView("home");
		return model;
 
	}
 
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	@ResponseBody
	public List<Tag> getTags(@RequestParam String tagName) {
 
		return simulateSearchResult(tagName);
 
	}
 
	private List<Tag> simulateSearchResult(String tagName) {
 
		List<Tag> result = new ArrayList<Tag>();
 
		// iterate a list and filter by tagName
		for (Tag tag : data) {
			if (tag.getTagName().contains(tagName)) {
				result.add(tag);
			}
		}
 
		return result;
	}
 
}