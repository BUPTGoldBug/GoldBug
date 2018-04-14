package bupt.ugrd.pojo;

import java.io.Serializable;

/**
 * Created by Luyao on 2018/4/14.
 */
public class BugBasic implements Serializable {
    private double lon;
    private double lat;
    private Integer bugId;

    public BugBasic(){}

    public BugBasic(double lon, double lat, Integer bugId){
        this.lon = lon;
        this.lat = lat;
        this.bugId = bugId;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }
}
