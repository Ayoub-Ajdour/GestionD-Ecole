package Servlets;


import beans.FiliereBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet({"/filiere"})
public class HomeServlet extends HttpServlet {
    public HomeServlet() {
    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        if (req.getSession().getAttribute("filiereBean") == null) {
            req.getSession().setAttribute("filiereBean", new FiliereBean());
        }

        req.getRequestDispatcher("/WEB-INF/filiere.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
