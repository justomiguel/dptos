package com.dptosweb.service.impl;


import com.dptosweb.dao.ciudades.ProvinciaDao;
import com.dptosweb.model.ciudades.Provincia;
import com.dptosweb.service.ProvinciaManager;
import com.dptosweb.service.ProvinciaService;

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
@Service("provinciaManager")
@WebService(serviceName = "ProvinciaService", endpointInterface = "com.dptosweb.service.ProvinciaService")
public class ProvinciaManagerImpl extends GenericManagerImpl<Provincia, Long> implements ProvinciaManager, ProvinciaService {

	private ProvinciaDao provinciasDao;


    @Override
    public void setProvinciasDao(final ProvinciaDao provinciaDao) {
        this.dao = provinciaDao;
        this.provinciasDao = provinciaDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Provincia getProvincia(final String userId) {
        return provinciasDao.get(new Long(userId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Provincia> getProvincias() {
    	if (provinciasDao!=null){
    		return provinciasDao.getAllDistinct();
    	}
        return new ArrayList<Provincia>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Provincia saveProvincia(final Provincia user) throws RuntimeException {
        try {
            return provinciasDao.saveProvincia(user);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new RuntimeException("Provincia '" + user.getNombre() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeProvincia(final Provincia user) {
        log.debug("removing user: " + user);
        provinciasDao.remove(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeProvincia(final String userId) {
        log.debug("removing user: " + userId);
        provinciasDao.remove(new Long(userId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Provincia> search(final String searchTerm) {
        return super.search(searchTerm, Provincia.class);
    }

}
