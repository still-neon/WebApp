package webapplication;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by EugenKrasotkin on 1/30/2018.
 */
public class UserService {
    private static final String PASS_MESSAGE = "";
    private static final String LOGIN_FAIL_MESSAGE = "Incorrect login";
    private static final String PASSWORD_FAIL_MESSAGE = "Incorrect password";
    private static final String FAIL_MESSAGE = "Incorrect login or password";

    public static AuthenticationState authenticate(String login, String password) throws Exception {
        UserDAO userInfo = new UserDAO();

        if (userInfo.getUser(login, encode(password)) != null)
            return AuthenticationState.PASS;
        else if (userInfo.getUserByLogin(login) != null)
            return AuthenticationState.PASSWORD_FAIL;
        else if (userInfo.getUserByPassword(encode(password)) != null)
            return AuthenticationState.LOGIN_FAIL;
        else
            return AuthenticationState.FAIL;
    }

    public enum AuthenticationState {
        PASS(true, PASS_MESSAGE), LOGIN_FAIL(false, LOGIN_FAIL_MESSAGE), PASSWORD_FAIL(false, PASSWORD_FAIL_MESSAGE), FAIL(false, FAIL_MESSAGE);

        public boolean accessGranted;
        public String messageText;

        AuthenticationState(boolean accessGranted, String messageText) {
            this.accessGranted = accessGranted;
            this.messageText = messageText;
        }
    }

    private static String encode(String st) {
        MessageDigest messageDigest;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }
        return md5Hex;
    }
}