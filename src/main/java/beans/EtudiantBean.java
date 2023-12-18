package beans;

import entities.Etudiant;
import service.EtudiantService;
import service.imp.EtudiantServiceImpl;

import java.util.List;

public class EtudiantBean {
    private Etudiant etudiant=new Etudiant();
    private boolean isModify=false;
    private EtudiantService etudiantService=new EtudiantServiceImpl();

    public EtudiantBean() {
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public boolean isModify() {
        return isModify;
    }
    public List<Etudiant> getEtudiants() {
        return this.etudiantService.getSortedEtudiants();
    }

    public void setModify(boolean modify) {
        isModify = modify;
    }

    public EtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }
    public String getLabel() {
        return this.isModify ? "Edit" : "Add";
    }
}
