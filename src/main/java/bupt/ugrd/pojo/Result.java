package bupt.ugrd.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by Luyao on 2018/1/21.
 */
public class Result implements Serializable{

    @JSONField(name = "success")
    private boolean isSuccess;
    private String des;
    private int status;
    private boolean isSuperUser = false;
    private UserDetail userDetail = null;

    public Result(){
        this.isSuccess = false;
        this.des = "";
        this.status = 0;
        this.isSuperUser = false;
        this.userDetail = null;
    }

    public Result(boolean isSuccess, String des, int status, boolean isSuperUser,UserDetail userDetail){
        this.isSuccess = isSuccess;
        this.des = des;
        this.status = status;
        this.isSuperUser = isSuperUser;
        this.userDetail = userDetail;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public boolean isSuperUser() {
        return isSuperUser;
    }

    public void setSuperUser(boolean superUser) {
        isSuperUser = superUser;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }
}
