package entities;

public class Filiere {
    private int idFiliere;
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

    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
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

    public Filiere(int idFiliere, String code, String libelle) {
        this.idFiliere = idFiliere;
        Code = code;
        this.libelle = libelle;
    }
}
