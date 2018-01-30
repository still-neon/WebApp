package webapplication;


/**
 * Created by EugenKrasotkin on 1/29/2018.
 */
public class LoginDAOImpl extends AbstractEntityDAO{
    private String CREDENTIALS_TABLE_NAME = "credentials";
    private static final String[] CREDENTIALS_COLUMNS_NAMES = {"login","password"};


    @Override
    protected String getTableName() {
        return CREDENTIALS_TABLE_NAME;
    }

    @Override
    protected String[] getColumnsNames() {
        return CREDENTIALS_COLUMNS_NAMES;
    }
}