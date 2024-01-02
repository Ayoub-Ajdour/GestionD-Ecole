package com.service.impl;

import com.dao.EtudiantDAO;
import com.entities.Etudiant;
import com.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantDAO etudiantDAO ;
    @Override
    @Transactional
    public void saveOrUpdate(Etudiant f) {
        this.etudiantDAO.saveOrUpdate(f);
    }

    @Override
    @Transactional
    public void delete(Etudiant f) {
        this.etudiantDAO.delete(f);
    }

    @Override
    public Etudiant getById(int id) {
        return this.etudiantDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Etudiant> getAll() {
        List<Etudiant> etudiants = this.etudiantDAO.getAll();

//		System.out.println("test ===> "+ filieres.get(0).getEtudiants().size());

        return etudiants;
    }
}
