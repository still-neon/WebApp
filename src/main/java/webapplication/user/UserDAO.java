package webapplication.user;

import webapplication.connection.ConnectionFactory;

import java.sql.*;

/**
 * Created by EugenKrasotkin on 1/29/2018.
 */
public class UserDAO {
    private static final String GET_USER_BY_LOGIN_QUERY_FORMAT = "SELECT * FROM users WHERE login='%s'";
    private static final String GET_USER_BY_PASSWORD_QUERY_FORMAT = "SELECT * FROM users WHERE password='%s'";
    private static final String GET_USER_QUERY_FORMAT = "SELECT * FROM users WHERE login='%s' AND password='%s'";

    public UserInfo getUser(String login, String password) throws SQLException {
        ResultSet rs = getResultSet(String.format(GET_USER_QUERY_FORMAT, login, password));
        return rs.next() ? toEntity(rs) : null;
    }

    public UserInfo getUserByLogin(String log) throws SQLException {
        ResultSet rs = getResultSet(String.format(GET_USER_BY_LOGIN_QUERY_FORMAT, log));
        return rs.next() ? toEntity(rs) : null;
    }

    public UserInfo getUserByPassword(String pass) throws SQLException {
        ResultSet rs = getResultSet(String.format(GET_USER_BY_PASSWORD_QUERY_FORMAT, pass));
        return rs.next() ? toEntity(rs) : null;
    }

    private ResultSet getResultSet(String query) throws SQLException {
        ResultSet rs;

        try (Connection con = ConnectionFactory.getConnection()) {
            Statement stm = con.createStatement();
            rs = stm.executeQuery(query);
        }
        return rs;
    }

    private UserInfo toEntity(ResultSet rs) throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(rs.getInt("id"));
        userInfo.setLogin(rs.getString("login"));
        userInfo.setPassword(rs.getString("password"));
        return userInfo;
    }
}