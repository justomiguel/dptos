package com.dptosweb.service;

import com.dptosweb.model.ciudades.Localidad;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Web Service interface so hierarchy of Generic Manager isn't carried through.
 */
@WebService
@Path("/localidades")
public interface LocalidadService {
    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param userId the identifier for the user
     * @return Localidad
     */
    @GET
    @Path("{id}")
    Localidad getLocalidad(@PathParam("id") String userId);

    /**
     * Retrieves a list of all users.
     *
     * @return List
     */
    @GET
    List<Localidad> getLocalidades();

    /**
     * Saves a user's information
     *
     * @param user the user's information
     * @return updated user
     * @throws LocalidadExistsException thrown when user already exists
     */
    @POST
    Localidad saveLocalidad(Localidad user) throws LocalidadExistsException;

    /**
     * Removes a user from the database by their userId
     *
     * @param userId the user's id
     */
    @DELETE
    void removeLocalidad(String userId);
}
