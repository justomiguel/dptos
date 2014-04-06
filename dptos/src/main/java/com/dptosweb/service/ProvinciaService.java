package com.dptosweb.service;

import com.dptosweb.model.ciudades.Provincia;

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
@Path("/provincias")
public interface ProvinciaService {
    /**
     * Retrieves a user by userId.  An exception is thrown if user not found
     *
     * @param userId the identifier for the user
     * @return Provincia
     */
    @GET
    @Path("{id}")
    Provincia getProvincia(@PathParam("id") String userId);

    /**
     * Retrieves a list of all users.
     *
     * @return List
     */
    @GET
    List<Provincia> getProvincias();

    /**
     * Saves a user's information
     *
     * @param user the user's information
     * @return updated user
     * @throws ProvinciaExistsException thrown when user already exists
     */
    @POST
    Provincia saveProvincia(Provincia user) throws ProvinciaExistsException;

    /**
     * Removes a user from the database by their userId
     *
     * @param userId the user's id
     */
    @DELETE
    void removeProvincia(String userId);
}
