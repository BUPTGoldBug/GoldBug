package bupt.ugrd.pojo;

import java.io.Serializable;

/**
 * Created by Luyao on 2018/1/21.
 */
public class User implements Serializable{
    private String userPhone;
    private String userName;

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
