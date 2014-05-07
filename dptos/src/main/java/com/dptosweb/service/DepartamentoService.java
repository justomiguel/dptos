package com.dptosweb.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.dptosweb.model.ciudades.Departamento;
import com.dptosweb.model.ciudades.Provincia;

/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/departamentos")
public interface DepartamentoService {
	
	/**
     * Retrieves a departamento by dptoId.  An exception is thrown if departamento not found
     *
     * @param dptoId the identifier for the departamento
     * @return Departamento
     */
    @GET
    @Path("{id}")
    Departamento getDepartamento(@PathParam("id") String dptoId);

    /**
     * Retrieves a list of all departamentos.
     *
     * @return List
     */
    @GET
    List<Departamento> getDepartamentos();

    /**
     * Saves a departamento's information
     *
     * @param departamento the departamento's information
     * @return updated departamento
     * @throws DepartamentoExistsException thrown when departamento already exists
     */
    @POST
    Departamento saveDepartamento(Departamento dpto) throws DepartamentoExistsException;

    /**
     * Removes a departamento from the database by their dptoId
     *
     * @param dptoId the departamento's id
     */
    @DELETE
    void removeDepartamento(String dptoId);

}
