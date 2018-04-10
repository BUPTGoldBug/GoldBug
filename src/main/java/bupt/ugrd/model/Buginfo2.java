package bupt.ugrd.model;

import javax.persistence.*;

/**
 * Created by Luyao on 2018/1/21.
 */

@Entity
public class Buginfo2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Buginfo bugId;

    //status  0可捉   1即将显示(T<startTime)   2不能捉(lifecount == 0 || T>=deathTime)
    // 特殊标志 -1 表示status从未被更新过的新记录  -2 表示
    private Integer status;

    private double lon;

    private double lat;

    private int lifecount;

    //private double TTL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Buginfo getBugId() {
        return bugId;
    }

    public void setBugId(Buginfo bugId) {
        this.bugId = bugId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public void setLifecount(int lifecount) {
        this.lifecount = lifecount;
    }

    public int getLifecount() {
        return lifecount;
    }

    /*
    public double getTTL() {
        return TTL;
    }

    public void setTTL(double TTL) {
        this.TTL = TTL;
    }*/
}
