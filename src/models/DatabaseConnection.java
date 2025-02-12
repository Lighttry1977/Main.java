package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/datafree";
    private static final String USER = "postgres";
    private static final String PASSWORD = "19771106"; // Замени на свой пароль

    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("✅ Подключение успешно: " + connection.getMetaData().getDatabaseProductName());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "❌ Ошибка подключения: " + e.getMessage(), e);
        }
    }
}

