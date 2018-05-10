package bupt.ugrd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Luyao on 2018/1/21.
 */
public class User implements Serializable{
    private String userPhone;
    private String userName;
    private String password;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    public void setCreateTime(Timestamp createTime){
        this.createTime = createTime;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
