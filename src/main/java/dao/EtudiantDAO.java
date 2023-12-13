package dao;

import entities.Etudiant;

public interface EtudiantDAO extends Idao<Etudiant>{
    Etudiant getByCne(String cne);
}
