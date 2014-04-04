package com.dptosweb.dao.ciudades;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;

import com.dptosweb.dao.GenericDao;
import com.dptosweb.model.ciudades.Departamento;

public interface DepartamentoDao extends GenericDao<Departamento, Long> {
	
	@Transactional
    Departamento loadDepartamentoByNombre(String nombre) throws EntityNotFoundException;

    /**
     * Gets a list of Departamentos ordered ASC.
     *
     * @return List populated list of Departamentos
     */
    List<Departamento> getDepartamentos();
    
    Departamento saveDepartamento (Departamento departamento);  
    
}
