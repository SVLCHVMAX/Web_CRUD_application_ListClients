package app.web;

import app.dao.ClientDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet для удаления пользователя
 */

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    ClientDAOImpl clientDAO = new ClientDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            clientDAO.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("/");
    }
}
