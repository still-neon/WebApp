package webapplication;

/**
 * Created by EugenKrasotkin on 1/30/2018.
 */
public class UserService {
    public static boolean authenticate(String login, String password) throws Exception {
        UserInfo userInfo = new UserDAO().getUser(login, password);//метод с енумом, пасс, фейл, сообщения. раздуплятор по резалту в дао

        return userInfo != null ? (userInfo.getLogin().equals(login) && userInfo.getPassword().equals(password)) : false;
    }

    public static String getErrorMessage(String login, String password) throws Exception {
        UserInfo userInfo = new UserDAO().getUser(login, password);

        if (userInfo != null) {
            return userInfo.getLogin().equals(login) ? "Incorrect password" : "Incorrect login";
        }
        return "Incorrect login or password";
    }
}