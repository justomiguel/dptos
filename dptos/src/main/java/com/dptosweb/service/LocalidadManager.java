package com.dptosweb.service;

import com.dptosweb.dao.ciudades.LocalidadDao;
import com.dptosweb.model.ciudades.Localidad;

import java.util.List;


/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:justomiguelvargas@gmail.com">Justo Vargas</a>
 *  Modified by <a href="mailto:  ">     </a>
 */
public interface LocalidadManager extends GenericManager<Localidad, Long> {

    void setLocalidadesDao(LocalidadDao userDao);

   
    Localidad getLocalidad(String userId);

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Localidad> getLocalidades();

    /**
     * Saves a user's information.
     *
     * @param user the user's information
     * @return user the updated user object
     */
    Localidad saveLocalidad(Localidad pcia) throws LocalidadExistsException;

    /**
     * Removes a user from the database
     *
     * @param user the user to remove
     */
    void removeLocalidad(Localidad user);

    /**
     * Removes a user from the database by their userId
     *
     * @param userId the user's id
     */
    void removeLocalidad(String userId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Localidad> search(String searchTerm);

}
