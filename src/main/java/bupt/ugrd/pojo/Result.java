package bupt.ugrd.pojo;

import java.io.Serializable;

/**
 * Created by Luyao on 2018/1/21.
 */
public class Result implements Serializable{
    private boolean isSuccess;
    private String des;
    private int status;

    public Result(boolean isSuccess, String des, int status){
        this.isSuccess = isSuccess;
        this.des = des;
        this.status = status;
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
}
