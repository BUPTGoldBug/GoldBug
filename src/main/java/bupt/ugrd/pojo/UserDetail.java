package bupt.ugrd.pojo;

import java.io.Serializable;

/**
 * Created by Luyao on 2018/4/29.
 */

public class UserDetail implements Serializable{
    private int userId;
    private double score = 0;//分数
    private String userName;
    private String userPhone;
    private boolean success;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
