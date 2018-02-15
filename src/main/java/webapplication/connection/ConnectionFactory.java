package webapplication.connection;

import java.sql.*;

/**
 * Created by EugenKrasotkin on 1/29/2018.
 */
public class ConnectionFactory {
    public static final String URL = "jdbc:postgresql://localhost:5433/WebApplication";
    public static final String USER = "postgres";
    public static final String PASSWORD = "still-neon84";

    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}