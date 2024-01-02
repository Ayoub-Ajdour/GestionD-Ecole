package com.service;

import com.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    void saveOrUpdate(Etudiant f);
    void delete(Etudiant f);
    Etudiant getById(int id);
    List<Etudiant> getAll();
}

