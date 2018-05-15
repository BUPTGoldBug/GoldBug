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

    /*  0在附近可以答题范围内&&未回答的active
        1已经回答成功的light
        2不在可答题范围内的&&未回答的non-active  */
    private int type;

    public BugBasic(){}

    public BugBasic(double lon, double lat, Integer bugId, Integer arIndex, int type){
        this.lon = lon;
        this.lat = lat;
        this.bugId = bugId;
        this.arIndex = arIndex;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
