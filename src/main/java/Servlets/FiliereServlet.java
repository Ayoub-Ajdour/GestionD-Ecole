package Servlets;


import beans.FiliereBean;
import dao.FiliereDAO;
import dao.impl.FiliereDAOImpl;
import entities.Filiere;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet({"/filiere/*"})
public class FiliereServlet extends HttpServlet {
    public FiliereServlet() {
    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        FiliereBean filiereBean = (FiliereBean)req.getSession().getAttribute("filiereBean");
        FiliereDAO filiereDao = new FiliereDAOImpl();
        filiereBean.getFiliere().setCode(req.getParameter("code"));
        filiereBean.getFiliere().setLibelle(req.getParameter("libelle"));
        if (req.getRequestURI().contains("save")) {
            filiereDao.saveOrUpdate(filiereBean.getFiliere());
            filiereBean.setFiliere(new Filiere());
            filiereBean.setModify(false);
        }

        int id;
        if (req.getRequestURI().contains("modify")) {
            id = Integer.parseInt(req.getParameter("id"));
            filiereBean.setFiliere((Filiere)filiereDao.getById(id));
            filiereBean.setModify(true);
        }

        if (req.getRequestURI().contains("delete")) {
            id = Integer.parseInt(req.getParameter("id"));
            filiereDao.delete((Filiere)filiereDao.getById(id));
        }

        resp.sendRedirect("../filiere");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
