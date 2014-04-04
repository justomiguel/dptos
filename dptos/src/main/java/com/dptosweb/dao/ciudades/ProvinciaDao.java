package com.dptosweb.dao.ciudades;

import java.util.List;

import com.dptosweb.dao.GenericDao;
import com.dptosweb.model.ciudades.Provincia;

public interface ProvinciaDao extends GenericDao<Provincia, Long> {
	
	Provincia loadProvinciaByNombre(String nombre);
	
	List<Provincia> getProvincias();
	
	Provincia saveProvincia(Provincia provincia);

}
