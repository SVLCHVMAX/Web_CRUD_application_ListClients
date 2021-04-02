package app.web;

import app.dao.ClientDAOImpl;
import app.model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientServlet extends HttpServlet {
    ClientDAOImpl clientDAO = new ClientDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> list = new ArrayList<>();
        try {
            String name = req.getParameter("name");
            System.out.println(name);
            list = clientDAO.getClientByName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.setAttribute("clientsList",list);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/client.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
