package webapplication.user;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by EugenKrasotkin on 1/31/2018.
 */
public class UserInfo {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String password;
}