package beans;

import entities.Filiere;
import service.FiliereService;
import service.imp.FiliereServiceImpl;

import java.util.List;

public class FiliereBean {
    private Filiere filiere = new Filiere();
    private boolean isModify = false;
    private FiliereService filiereService = new FiliereServiceImpl();

    public FiliereBean() {
    }

    public Filiere getFiliere() {
        return this.filiere;

    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public List<Filiere> getFilieres() {
        return this.filiereService.getSortedFilieres();
    }

    public boolean isModify() {
        return this.isModify;
    }

    public void setModify(boolean modify) {
        this.isModify = modify;
    }

    public String getLabel() {
        return this.isModify ? "Edit" : "Add";
    }
}
