package Servlets;


import beans.EtudiantBean;
import beans.FiliereBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet({"/etudiant"})
public class HomeServletf extends HttpServlet {
    public HomeServletf() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("etudiantBean") == null) {
            req.getSession().setAttribute("etudiantBean", new EtudiantBean());
            req.getSession().setAttribute("filiereBean", new FiliereBean());
        }

        req.getRequestDispatcher("/WEB-INF/etudiant.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
