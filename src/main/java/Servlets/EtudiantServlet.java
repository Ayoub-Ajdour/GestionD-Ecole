package Servlets;

import beans.EtudiantBean;
import beans.FiliereBean;
import dao.EtudiantDAO;
import dao.FiliereDAO;
import dao.impl.EtudiantDAOImpl;
import dao.impl.FiliereDAOImpl;
import entities.Etudiant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/etudiant/*"})

public class EtudiantServlet extends HttpServlet {
    public EtudiantServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EtudiantBean etudiantBean = (EtudiantBean) req.getSession().getAttribute("etudiantBean");
        FiliereBean filiereBean = (FiliereBean)req.getSession().getAttribute("filiereBean");
        EtudiantDAO etudiantDAO=new EtudiantDAOImpl();
        etudiantBean.getEtudiant().setNom(req.getParameter("nom"));
        etudiantBean.getEtudiant().setPrenom(req.getParameter("prenom"));
        etudiantBean.getEtudiant().setCne(req.getParameter("cne"));

       // Filiere c=null;
        Integer idf= null;
        if(req.getParameter("filiere")!=null){
         idf= Integer.valueOf(req.getParameter("filiere"));}
        FiliereDAO filiereDAOa=new FiliereDAOImpl();
        etudiantBean.getEtudiant().setFiliere(filiereDAOa.getById(idf));
        if (req.getRequestURI().contains("save")) {
            etudiantDAO.saveOrUpdate(etudiantBean.getEtudiant());
            etudiantBean.setEtudiant(new Etudiant());
            etudiantBean.setModify(false);
        }
        int id;
        if (req.getRequestURI().contains("modify")) {
          id = Integer.parseInt(req.getParameter("id"));
          etudiantBean.setEtudiant((Etudiant) etudiantDAO.getById(id));
            etudiantBean.setModify(true);
        }
        if (req.getRequestURI().contains("delete")) {
            id = Integer.parseInt(req.getParameter("id"));
            etudiantDAO.delete((Etudiant) etudiantDAO.getById(id));
        }
        resp.sendRedirect("../etudiant");
    }
}
