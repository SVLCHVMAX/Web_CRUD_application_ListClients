package app.dao;

import app.model.Client;

import java.sql.SQLException;
import java.util.List;

/**
 * Интерфейс с описанием общих методов для взаимодействия модели Клиента с базой данных
 */

public interface ClientDAO {
    boolean add(Client client) throws SQLException;

    boolean update(Client client) throws SQLException;

    boolean delete(int id) throws SQLException;

    List<Client> getAll() throws SQLException;

    Client getClientById(int id) throws SQLException;

    List getClientByName(String name) throws SQLException;
}
