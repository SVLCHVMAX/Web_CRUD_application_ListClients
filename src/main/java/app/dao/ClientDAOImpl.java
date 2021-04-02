package app.dao;

import app.ConnectDatabase;
import app.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для реализация методов интерфейса ClientDAO для взаимодействия с базой данных
 */
public class ClientDAOImpl implements ClientDAO {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private boolean query;
    private final String INSERT_CLIENT_SQL = "INSERT INTO clients (last_name, name, middle_name, email, tel_number) VALUES (?,?,?,?,?);";
    private final String SELECT_ALL_CLIENT = "SELECT * FROM clients;";
    private final String SELECT_CLIENT_BY_ID = "SELECT * FROM clients WHERE id = ?;";
    private final String SELECT_CLIENT_BY_NAME = "SELECT * FROM clients WHERE name = ?;";
    private final String DELETE_CLIENT_SQL = "DELETE FROM clients WHERE id = ?;";
    private final String UPDATE_CLIENT_SQL = "UPDATE clients SET last_name = ?, name = ?, middle_name = ?, email = ?, tel_number = ? WHERE id = ?;";
    private final String SELECT_SORT_ALL_CLIENT = "SELECT * FROM clients order by last_name;";



    @Override
    public boolean add(Client client) throws SQLException {
        connection = ConnectDatabase.getConnection();
        preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL);
        preparedStatement.setString(1,client.getLastName());
        preparedStatement.setString(2,client.getName());
        preparedStatement.setString(3, client.getMiddleName());
        preparedStatement.setString(4, client.getEmail());
        preparedStatement.setString(5, client.getTelNumber());
        query = preparedStatement.execute();
        ConnectDatabase.closeConnection();

        return query;
    }

    @Override
    public boolean update(Client client) throws SQLException {
        connection = ConnectDatabase.getConnection();
        preparedStatement = connection.prepareStatement(UPDATE_CLIENT_SQL);
        preparedStatement.setString(1, client.getLastName());
        preparedStatement.setString(2, client.getName());
        preparedStatement.setString(3, client.getMiddleName());
        preparedStatement.setString(4, client.getEmail());
        preparedStatement.setString(5, client.getTelNumber());
        preparedStatement.setInt(6,client.getId());
        query = preparedStatement.execute();
        ConnectDatabase.closeConnection();

        return query;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        connection = ConnectDatabase.getConnection();
        preparedStatement = connection.prepareStatement(DELETE_CLIENT_SQL);
        preparedStatement.setInt(1,id);
        query = preparedStatement.execute();
        ConnectDatabase.closeConnection();

        return query;
    }

    @Override
    public List<Client> getAll() throws SQLException {
        connection = ConnectDatabase.getConnection();
        List<Client> clients = new ArrayList<>();
        resultSet = connection.createStatement().executeQuery(SELECT_ALL_CLIENT);
        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setLastName(resultSet.getString("last_name"));
            client.setName(resultSet.getString("name"));
            client.setMiddleName(resultSet.getString("middle_name"));
            client.setEmail(resultSet.getString("email"));
            client.setTelNumber(resultSet.getString("tel_number"));
            clients.add(client);
        }
        ConnectDatabase.closeConnection();

        return clients;
    }

    public List<Client> getSortAll() throws SQLException {
        connection = ConnectDatabase.getConnection();
        List<Client> clients = new ArrayList<>();
        resultSet = connection.createStatement().executeQuery(SELECT_SORT_ALL_CLIENT);
        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setLastName(resultSet.getString("last_name"));
            client.setName(resultSet.getString("name"));
            client.setMiddleName(resultSet.getString("middle_name"));
            client.setEmail(resultSet.getString("email"));
            client.setTelNumber(resultSet.getString("tel_number"));
            clients.add(client);
        }
        ConnectDatabase.closeConnection();

        return clients;
    }

    @Override
    public Client getClientById(int id) throws SQLException {
        connection = ConnectDatabase.getConnection();
        preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        Client client = new Client();
        while (resultSet.next()) {
            client.setId(resultSet.getInt("id"));
            client.setLastName(resultSet.getString("last_name"));
            client.setName(resultSet.getString("name"));
            client.setMiddleName(resultSet.getString("middle_name"));
            client.setEmail(resultSet.getString("email"));
            client.setTelNumber(resultSet.getString("tel_number"));
        }
        ConnectDatabase.closeConnection();

        return client;
    }

    @Override
    public List<Client> getClientByName(String name) throws SQLException {
        connection = ConnectDatabase.getConnection();
        List<Client> clients = new ArrayList<>();
        preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_NAME);
        preparedStatement.setString(1,name);
        resultSet = preparedStatement.executeQuery();
        Client client = new Client();
        while (resultSet.next()) {
            client.setId(resultSet.getInt("id"));
            client.setLastName(resultSet.getString("last_name"));
            client.setName(resultSet.getString("name"));
            client.setMiddleName(resultSet.getString("middle_name"));
            client.setEmail(resultSet.getString("email"));
            client.setTelNumber(resultSet.getString("tel_number"));
            clients.add(client);
        }
        ConnectDatabase.closeConnection();

        return clients;
    }
}
