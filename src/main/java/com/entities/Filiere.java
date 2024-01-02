package com.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "filiere", catalog = "fpl2023")
public class Filiere {

    @Id
    @Column(name = "idFiliere")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFiliere;
    @Basic
    @Column(name = "Code", nullable = false, length = 50)
    private String code;
    @Basic
    @Column(name = "libelle", nullable = false, length = 50)
    private String libelle;
    //    @OneToMany(mappedBy = "filiere")
    //fetch = FetchType.LAZY
    @OneToMany(mappedBy = "filiere")
    private Set<Etudiant> etudiantsByIdFiliere = new HashSet<Etudiant>(0);


    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public Set<Etudiant> getEtudiantsByIdFiliere() {
        return etudiantsByIdFiliere;
    }

    public void setEtudiantsByIdFiliere(Set<Etudiant> etudiantsByIdFiliere) {
        this.etudiantsByIdFiliere = etudiantsByIdFiliere;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFiliere, code, libelle, etudiantsByIdFiliere);
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Filiere filiere = (Filiere) o;
//        return idFiliere == filiere.idFiliere &&
//                Objects.equals(code, filiere.code) &&
//                Objects.equals(libelle, filiere.libelle);
//    }
}
