package service.imp;

import dao.EtudiantDAO;
import dao.impl.EtudiantDAOImpl;
import entities.Etudiant;
import service.EtudiantService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EtudiantServiceImpl implements EtudiantService {
    EtudiantDAO dao=new EtudiantDAOImpl();
    @Override
    public List<Etudiant> getSortedEtudiants() {
        List<Etudiant> etudiants = this.dao.getAll();
        System.out.println("Etudiant :" + etudiants.size());
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            public int compare(Etudiant o1, Etudiant o2) {
                return o1.getCne().compareTo(o2.getCne());
            }
        });
        return etudiants;
    }
}
