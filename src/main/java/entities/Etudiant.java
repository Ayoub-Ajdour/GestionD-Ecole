package entities;

public class Etudiant {
    private int idEtudiant;
    private String nom;
    private String prenom;
    private String cne;
    private Filiere filiere;

    @Override
    public String toString() {
        return "Etudiant{" +
                "idEtudiant=" + idEtudiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cne='" + cne + '\'' +
                ", filiere=" + filiere +
                '}';
    }

    public Etudiant() {
    }

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

    public Etudiant(int idEtudiant, String nom, String prenom, String cne, Filiere filiere) {
        this.idEtudiant = idEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        this.filiere = filiere;
    }
}
