package bupt.ugrd.pojo;

import java.io.Serializable;

/**
 * Created by Luyao on 2018/4/14.
 */
public class BugBasic implements Serializable {
    private double lon;
    private double lat;
    private Integer bugId;
    private Integer arIndex;

    public BugBasic(){}

    public BugBasic(double lon, double lat, Integer bugId, Integer arIndex){
        this.lon = lon;
        this.lat = lat;
        this.bugId = bugId;
        this.arIndex = arIndex;
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

    public Integer getArIndex() {
        return arIndex;
    }

    public void setArIndex(Integer arIndex) {
        this.arIndex = arIndex;
    }
}
