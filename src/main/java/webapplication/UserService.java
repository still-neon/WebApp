package webapplication;

/**
 * Created by EugenKrasotkin on 1/30/2018.
 */
public class UserService {
    public static boolean checkCredentials(String username, String password) throws Exception {
        UserDAO userDAO = new UserDAO();

        if (userDAO.getUser(username, password) != null)
            return true;
        else
            return false;
    }
}