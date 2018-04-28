package bupt.ugrd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Common {
    private  int bid; // 同bugId
    private  int bugId;
    private  String choose;
    private  int userId;
    private double rt_lon;
    private double rt_lat;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp debugDate;


    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDebugDate(Timestamp debugDate) {
        this.debugDate = debugDate;
    }

    public Timestamp getDebugDate() {
        return debugDate;
    }

    public double getRt_lat() {
        return rt_lat;
    }

    public void setRt_lat(double rt_lat) {
        this.rt_lat = rt_lat;
    }

    public double getRt_lon() {
        return rt_lon;
    }

    public void setRt_lon(double rt_lon) {
        this.rt_lon = rt_lon;
    }
}
