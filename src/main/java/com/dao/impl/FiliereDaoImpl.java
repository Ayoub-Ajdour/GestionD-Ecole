package com.dao.impl;

import com.dao.FiliereDAO;
import com.entities.Filiere;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FiliereDaoImpl extends HibernateDaoSupport implements FiliereDAO {

	@Autowired
	public void setUpSessionFactory(SessionFactory sf) {
		this.setSessionFactory(sf);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(Filiere f) {
	
		this.getHibernateTemplate().saveOrUpdate(f);
	}
	
	
	@Override
	@Transactional
	public void delete(Filiere f) {
		
		this.getHibernateTemplate().delete(f);
	}

	@Override
	public Filiere getById(int id) {
		
		return this.getHibernateTemplate().get(Filiere.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Filiere> getAll() {

		return (List<Filiere>) this.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(Filiere.class));
	}
}
