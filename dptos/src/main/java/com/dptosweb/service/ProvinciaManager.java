package com.dptosweb.service;

import com.dptosweb.dao.ciudades.ProvinciaDao;
import com.dptosweb.model.ciudades.Provincia;

import java.util.List;


/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author <a href="mailto:justomiguelvargas@gmail.com">Justo Vargas</a>
 *  Modified by <a href="mailto:  ">     </a>
 */
public interface ProvinciaManager extends GenericManager<Provincia, Long> {

    void setProvinciasDao(ProvinciaDao userDao);

   
    Provincia getProvincia(String userId);

    /**
     * Retrieves a list of all users.
     * @return List
     */
    List<Provincia> getProvincias();

    /**
     * Saves a user's information.
     *
     * @param user the user's information
     * @return user the updated user object
     */
    Provincia saveProvincia(Provincia pcia) throws ProvinciaExistsException;

    /**
     * Removes a user from the database
     *
     * @param user the user to remove
     */
    void removeProvincia(Provincia user);

    /**
     * Removes a user from the database by their userId
     *
     * @param userId the user's id
     */
    void removeProvincia(String userId);

    /**
     * Search a user for search terms.
     * @param searchTerm the search terms.
     * @return a list of matches, or all if no searchTerm.
     */
    List<Provincia> search(String searchTerm);

}
