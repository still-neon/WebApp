package webapplication;

import java.sql.*;

/**
 * Created by EugenKrasotkin on 1/29/2018.
 */
public abstract class AbstractEntityDAO {
    private static final String GET_ENTITY_QUERY_FORMAT = "SELECT %s FROM %s WHERE %s=%s";
    LoginDAOImpl ld = new LoginDAOImpl();

    protected abstract String getTableName();
    protected abstract String[] getColumnsNames();


    private ResultSet getResultSet(String query, String value) throws SQLException {
        ResultSet rs;

        try (Connection con = ConnectionFactory.getConnection()) {
            Statement stm = con.createStatement();
            rs = stm.executeQuery(String.format(query, ld.getColumnsNames()[1],ld.getTableName(), ld.getColumnsNames()[0], value));
        }
        return rs;
    }

    protected String checkCredentials(String value) throws SQLException {
        ResultSet rs = getResultSet(GET_ENTITY_QUERY_FORMAT, value);
        return rs.getString(0);
    }
}