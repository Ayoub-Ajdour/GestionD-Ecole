package com.dao.impl;

import com.dao.EtudiantDAO;
import com.entities.Etudiant;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EtudiantDaoImpl extends HibernateDaoSupport implements EtudiantDAO {
    @Autowired
    public void setUpSessionFactory(SessionFactory sf) {
        this.setSessionFactory(sf);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Etudiant f) {
        this.getHibernateTemplate().saveOrUpdate(f);
    }

    @Override
    @Transactional
    public void delete(Etudiant f) {
        this.getHibernateTemplate().delete(f);
    }

    @Override
    public Etudiant getById(int id) {

        return this.getHibernateTemplate().get(Etudiant.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Etudiant> getAll() {
        return (List<Etudiant>) this.getHibernateTemplate().findByCriteria(
                DetachedCriteria.forClass(Etudiant.class));
    }
}
