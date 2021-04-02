package app.web;

import app.dao.ClientDAOImpl;
import app.model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    ClientDAOImpl clientDAO = new ClientDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String lastName = req.getParameter("lastName");
        String name = req.getParameter("name");
        String middleName = req.getParameter("middleName");
        String email = req.getParameter("email");
        String telNumber = req.getParameter("telNumber");

        Client client = new Client(lastName,name,middleName,email,telNumber);
        try {
            clientDAO.add(client);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            resp.sendRedirect("/");

    }
}
