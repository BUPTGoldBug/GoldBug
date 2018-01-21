package bupt.ugrd.model;

import javax.persistence.*;

/**
 * Created by Luyao on 2018/1/21.
 */
@Entity
public class Userinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userPhone;

    private String userName;

    public Userinfo(){}

    public Userinfo(String userPhone, String userName){
        this.userPhone = userPhone;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
