package com.dptosweb.dao.ciudades.hibernate;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dptosweb.dao.ciudades.ProvinciaDao;
import com.dptosweb.dao.hibernate.GenericDaoHibernate;
import com.dptosweb.model.ciudades.Provincia;

@Repository("provinciaDao")
public class ProvinciaDaoHibernate extends GenericDaoHibernate<Provincia, Long> implements ProvinciaDao{
	
	public ProvinciaDaoHibernate(){
		super(Provincia.class);
	}

	@SuppressWarnings("unchecked")
    public List<Provincia> getProvincias() {
        Query qry = getSession().createQuery("from provincias p order by upper(p.nombre)");
        return qry.list();
    }

    
    public Provincia saveProvincia(Provincia provincia) {
        if (log.isDebugEnabled()) {
            log.debug("provincia id: " + provincia.getId());
        }
        getSession().saveOrUpdate(provincia);
        
        getSession().flush();
        return provincia;
    }
    
    @Override
    public Provincia save(Provincia provincia) {
        return this.saveProvincia(provincia);
    }

    
    public Provincia loadProvinciaByNombre(String nombre) throws EntityNotFoundException {
        List provList = getSession().createCriteria(Provincia.class).add(Restrictions.eq("nombre", nombre)).list();
        if (provList == null || provList.isEmpty()) {
            throw new EntityNotFoundException("provincia '" + nombre + "' not found...");
        } else {
            return (Provincia) provList.get(0);
        }
    }
	

}
