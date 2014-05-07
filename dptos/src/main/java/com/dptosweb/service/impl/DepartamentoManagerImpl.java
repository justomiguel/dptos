package com.dptosweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.dptosweb.dao.ciudades.DepartamentoDao;
import com.dptosweb.model.ciudades.Departamento;
import com.dptosweb.service.DepartamentoExistsException;
import com.dptosweb.service.DepartamentoManager;
import com.dptosweb.service.DepartamentoService;

@Service("departamentoManager")
@WebService(serviceName = "DepartamentoService", endpointInterface = "com.dptosweb.service.DepartamentoService")
public class DepartamentoManagerImpl extends GenericManagerImpl<Departamento, Long> implements DepartamentoManager, DepartamentoService{
	
	private DepartamentoDao departamentoDao;


    @Override
    public void setDepartamentoDao(final DepartamentoDao departamentoDao) {
        this.dao = departamentoDao;
        this.departamentoDao = departamentoDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Departamento getDepartamento(final String dptoId) {
        return departamentoDao.get(new Long(dptoId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Departamento> getDepartamentos() {
    	if (departamentoDao!=null){
    		return departamentoDao.getAllDistinct();
    	}
        return new ArrayList<Departamento>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Departamento saveDepartamento(final Departamento dpto) throws DepartamentoExistsException {
        try {
            return departamentoDao.saveDepartamento(dpto);
        } catch (final Exception e) {
            e.printStackTrace();
            log.warn(e.getMessage());
            throw new DepartamentoExistsException("Departamento '" + dpto.getNombre() + "' already exists!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeDepartamento(final Departamento dpto) {
        log.debug("removing departamento: " + dpto.getNombre());
        departamentoDao.remove(dpto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeDepartamento(final String dptoId) {
        log.debug("removing departamento: " + dptoId);
        departamentoDao.remove(new Long (dptoId));;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Departamento> search(final String searchTerm) {
        return super.search(searchTerm, Departamento.class);
    }
}
