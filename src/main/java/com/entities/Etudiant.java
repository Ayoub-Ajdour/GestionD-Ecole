package com.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "etudiant", catalog = "fpl2023")
public class Etudiant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEtudiant", nullable = false)
    private int idEtudiant;
    @Basic
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;
    @Basic
    @Column(name = "cne", nullable = false, length = 50)
    private String cne;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filiere", referencedColumnName = "idFiliere", nullable = false)
    private Filiere filiere;



    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return idEtudiant == etudiant.idEtudiant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEtudiant);
    }

}
