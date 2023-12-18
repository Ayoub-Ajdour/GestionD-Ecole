package entities;

import jakarta.persistence.*;

@Entity
public class Filiere {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idFiliere", nullable = false)
    private int idFiliere;
    @Basic
    @Column(name = "Code", nullable = false, length = 50)
    private String code;
    @Basic
    @Column(name = "libelle", nullable = false, length = 50)
    private String libelle;

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
}
