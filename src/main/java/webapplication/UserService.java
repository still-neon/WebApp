package webapplication;

/**
 * Created by EugenKrasotkin on 1/30/2018.
 */
public class UserService {
    public static boolean checkCredentials(String username, String password) throws Exception {
        return new UserDAO().getUser(username, password) != null ? true : false;
    }
}