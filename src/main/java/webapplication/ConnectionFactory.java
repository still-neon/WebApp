package webapplication;

import java.sql.*;

/**
 * Created by EugenKrasotkin on 1/29/2018.
 */
public class ConnectionFactory {
    public static final String URL = "jdbc:postgresql://localhost:5433/WebApplication";
    public static final String USER = "postgres";
    public static final String PASSWORD = "still-neon84";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}