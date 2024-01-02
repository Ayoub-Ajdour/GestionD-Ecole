package com.service.impl;

import com.dao.FiliereDAO;
import com.entities.Filiere;
import com.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FiliereServiceImpl implements FiliereService {

	@Autowired
	private FiliereDAO filiereDao ;

	@Override
	@Transactional
	public void saveOrUpdate(Filiere f) {
		this.filiereDao.saveOrUpdate(f);
	}

	@Override
	@Transactional
	public void delete(Filiere f) {
		this.filiereDao.delete(f);		
	}

	@Override
	public Filiere getById(int id) {
		return this.filiereDao.getById(id);
	}

	
	@Transactional
	public List<Filiere> getAll() {
		List<Filiere> filieres = this.filiereDao.getAll();
				return filieres;
	}
}
