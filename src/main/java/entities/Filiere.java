package entities;

public class Filiere {
    private Integer idFiliere;
    private String Code;
    private String libelle;

    @Override
    public String toString() {
        return "Filiere{" +
                "idFiliere=" + idFiliere +
                ", Code='" + Code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public Integer getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Integer idFiliere) {
        this.idFiliere = idFiliere;
    }



    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Filiere() {
    }

    public Filiere(Integer idFiliere, String code, String libelle) {
        this.idFiliere = idFiliere;
        Code = code;
        this.libelle = libelle;
    }
}
