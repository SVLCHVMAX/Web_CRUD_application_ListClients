package app.web;

import app.dao.ClientDAOImpl;
import app.model.Client;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet для отображения списка всех пользователей
 */
@WebServlet(name = "ListServlet")
public class ListServlet extends HttpServlet {
    ClientDAOImpl clientDAO = new ClientDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> list = new ArrayList<>();
        try {
            list = clientDAO.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.setAttribute("clientsList", list);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> list;

        if (request.getParameter("sort") != null) {
            try {
                list = clientDAO.getSortAll();
                request.setAttribute("clientsList", list);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            doGet(request, response);
        }
    }
}
