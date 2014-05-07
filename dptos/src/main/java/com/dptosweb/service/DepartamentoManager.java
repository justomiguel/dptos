package com.dptosweb.service;

import java.util.List;

import com.dptosweb.dao.ciudades.DepartamentoDao;
import com.dptosweb.model.ciudades.Departamento;
import com.dptosweb.model.ciudades.Provincia;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 */
public interface DepartamentoManager extends GenericManager<Departamento, Long>{
	
	void setDepartamentoDao(DepartamentoDao userDao);

	   
    Departamento getDepartamento(String dptoId);

    /**
     * Retrieves a list of all departamentos.
     * @return List
     */
    List<Departamento> getDepartamentos();

    /**
     * Saves a departamento's information.
     *
     * @param departamento the departamento's information
     * @return departamento the updated departamento object
     */
    Departamento saveDepartamento(Departamento dpto) throws DepartamentoExistsException;

    /**
     * Removes a departamento from the database
     *
     * @param departamento the departamento to remove
     */
    void removeDepartamento(Departamento dpto);

    /**
     * Removes a departamento from the database by their dptoId
     *
     * @param dptoId the departamento's id
     */
    void removeDepartamento(String dptoId);

    /**
     * Search a departamento for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Departamento> search(String searchTerm);
}
