package bupt.ugrd.model;

import javax.persistence.*;
import java.sql.Timestamp;

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

    private Timestamp createTime;

    private String password;

    public Userinfo(){}

    public Userinfo(String userPhone, String userName, Timestamp createTime, String password){
        this.userPhone = userPhone;
        this.userName = userName;
        this.createTime = createTime;
        this.password = password;
    }

    public void setCreateTime(Timestamp createTime){
        this.createTime = createTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
