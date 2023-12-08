package dao;

import entities.Filiere;

public interface FiliereDAO extends Idao<Filiere>{
    Filiere getByCode(String Code);
}
