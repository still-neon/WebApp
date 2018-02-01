package webapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EugenKrasotkin on 1/29/2018.
 */
public class UserDAO {
    private static final String TABLE_NAME = "users";
    private static final String[] COLUMNS_NAMES = {"id", "login", "password"};
    private static final String GET_ENTITY_QUERY_FORMAT = "SELECT " + COLUMNS_NAMES[0] + " FROM " + TABLE_NAME + "WHERE (" + COLUMNS_NAMES[1] + "=%s) AND (" + COLUMNS_NAMES[2] + "=%s)";

    public UserInfo getUser(String login, String password) throws Exception {
        ResultSet rs = getResultSet(GET_ENTITY_QUERY_FORMAT, login, password);
        return rs.next() ? toEntity(rs) : null;
    }


    private ResultSet getResultSet(String query, String login, String password) throws SQLException {
        ResultSet rs;
        Connection con = ConnectionFactory.getConnection();
        Statement stm = con.createStatement();
        rs = stm.executeQuery(String.format(query, login, password));
        //try (Connection con = ConnectionFactory.getConnection()) {

        //}
        return rs;
    }

    public UserInfo toEntity (ResultSet rs) throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(rs.getInt("id"));
        userInfo.setLogin(rs.getString("login"));
        userInfo.setPassword(rs.getString("password"));
        return userInfo;
    }
}