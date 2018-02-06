package webapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EugenKrasotkin on 1/29/2018.
 */
public class UserDAO {
    private static final String GET_USER_BY_LOGIN_QUERY_FORMAT = "SELECT * FROM users WHERE login='%s'";
    private static final String GET_USER_BY_PASSWORD_QUERY_FORMAT = "SELECT * FROM users WHERE password='%s'";
    private static final String GET_USER_QUERY_FORMAT = "SELECT * FROM users WHERE login='%s' AND password='%s'";

    public UserInfo getUser(String login, String password) throws Exception {
        ResultSet rs = getResultSet(GET_USER_QUERY_FORMAT, login, password);//get back

        if (rs.next()) {
            return toEntity(rs);
        } else {
            return getUserByLogin(login) != null ? getUserByLogin(login) : getUserByPassword(password);
        }
    }

    private UserInfo getUserByLogin(String log) throws SQLException {
        ResultSet rs = getResultSet(GET_USER_BY_LOGIN_QUERY_FORMAT, log);
        return rs.next() ? toEntity(rs) : null;
    }

    private UserInfo getUserByPassword(String pass) throws SQLException {
        ResultSet rs = getResultSet(GET_USER_BY_PASSWORD_QUERY_FORMAT, pass);
        return rs.next() ? toEntity(rs) : null;
    }

    private ResultSet getResultSet(String query, String... creds) throws SQLException {//перделать, чтобы не зависило от параметров, named query
        ResultSet rs;

        try (Connection con = ConnectionFactory.getConnection()) {
            Statement stm = con.createStatement();
            rs = stm.executeQuery(String.format(query, creds));
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