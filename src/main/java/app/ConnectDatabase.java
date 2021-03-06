package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс устанавливающий соединение с базой данных
 */

public class ConnectDatabase {

    private static final String JDBC_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    private static final String URL = "jdbc:hsqldb:file:/Users/maksimsavelchev/Downloads/MyProject/Clients/database;hsqldb.lock_file=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}

