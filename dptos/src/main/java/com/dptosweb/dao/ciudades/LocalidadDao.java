package com.dptosweb.dao.ciudades;

import java.util.List;

import com.dptosweb.dao.GenericDao;
import com.dptosweb.model.ciudades.Localidad;

public interface LocalidadDao extends GenericDao<Localidad, Long> {
	
	Localidad loadLocalidadByNombre(String nombre);
	
	List<Localidad> getLocalidades();
	
	Localidad saveLocalidad(Localidad localidad);

}
