package com.dptosweb.service.impl;


import com.dptosweb.dao.ciudades.LocalidadDao;
import com.dptosweb.model.ciudades.Localidad;
import com.dptosweb.service.LocalidadManager;
import com.dptosweb.service.LocalidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of UserManager interface.
 *
 * @author <a href="mailto:justomiguelvargas@gmail.com">Justo Vargas</a>
 */
@Service("localidadManager")
@WebService(serviceName = "LocalidadService", endpointInterface = "com.dptosweb.service.LocalidadService")
public class LocalidadManagerImpl extends GenericManagerImpl<Localidad, Long> implements LocalidadManager, LocalidadService {

	private LocalidadDao localidadesDao;


    @Override
    public void setLocalidadesDao(final LocalidadDao provinciaDao) {
        this.dao = provinciaDao;
        this.localidadesDao = provinciaDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Localidad getLocalidad(final String userId) {
        return localidadesDao.get(new Long(userId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Localidad> getLocalidades() {
    	if (localidadesDao!=null){
    		return localidadesDao.getAllDistinct();
    	}
        return new ArrayList<Localidad>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Localidad saveLocalidad(final Localidad user) throws RuntimeException {
        try {
            return localidadesDao.saveLocalidad(user);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new RuntimeException("Localidad '" + user.getNombre() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLocalidad(final Localidad user) {
        log.debug("removing user: " + user);
        localidadesDao.remove(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLocalidad(final String userId) {
        log.debug("removing user: " + userId);
        localidadesDao.remove(new Long(userId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Localidad> search(final String searchTerm) {
        return super.search(searchTerm, Localidad.class);
    }

}
