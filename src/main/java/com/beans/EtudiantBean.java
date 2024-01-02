package com.beans;

import com.entities.Etudiant;
import com.service.EtudiantService;
import com.service.FiliereService;
import com.service.impl.EtudiantServiceImpl;
import com.service.impl.FiliereServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean
@Scope("session")
public class EtudiantBean {
    @Autowired
    private EtudiantService etudiantService;

    private Etudiant etudiant;
    private boolean modifyContext;
    private int filiere;
    @Autowired
    private FiliereService filiereService;

    public int getFiliere() {
        return filiere;
    }

    public void setFiliere(int filiere) {
        this.filiere = filiere;
    }





    public EtudiantBean() {

        this.etudiant = new Etudiant();
        this.modifyContext = false;
        this.etudiantService =new EtudiantServiceImpl();
        this.filiereService=new FiliereServiceImpl();
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }


    public boolean isModifyContext() {
        return modifyContext;
    }

    public void setModifyContext(boolean modifyContext) {
        this.modifyContext = modifyContext;
    }

    public List<Etudiant> getEtudiants() {

        return this.etudiantService.getAll();
    }

    public String getLabel() {
        return isModifyContext() ? "Edit" : "Add";
    }

    //@Transactional
    public void save() {
       this.etudiant.setFiliere(filiereService.getById(this.filiere));
        this.etudiantService.saveOrUpdate(this.etudiant);
        this.etudiant = new Etudiant();
        this.setModifyContext(false);
    }

    public void modifyy(Etudiant f) {

        this.etudiant = f;
        this.setModifyContext(true);
    }

    //@Transactional
    public void delete(Etudiant f) {
        this.etudiantService.delete(f);
        this.etudiant = new Etudiant();
    }
}
