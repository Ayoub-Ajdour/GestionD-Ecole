package entities;

import jakarta.persistence.*;

@Entity
public class Etudiant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEtudiant", nullable = false)
    private int idEtudiant;

    @Basic
    @Column(name = "nom", nullable = false, length = 20)
    private String nom;

    @Basic
    @Column(name = "prenom", nullable = false, length = 20)
    private String prenom;

    @Basic
    @Column(name = "cne", nullable = false, length = 20)
    private String cne;

    @ManyToOne
    @JoinColumn(name = "filiere", nullable = false)
    private Filiere filiere;

    // Getters and setters

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
}
