package service.imp;

import dao.FiliereDAO;
import dao.impl.FiliereDAOImpl;
import entities.Filiere;
import service.FiliereService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FiliereServiceImpl implements FiliereService {
    FiliereDAO dao = new FiliereDAOImpl();

    public FiliereServiceImpl() {
    }

    public List<Filiere> getSortedFilieres() {

        List<Filiere> filieres = this.dao.getAll();
        System.out.println("Filiere :" + filieres.size());
        Collections.sort(filieres, new Comparator<Filiere>() {
            public int compare(Filiere o1, Filiere o2) {
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        return filieres;
    }
}
