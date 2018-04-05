package bupt.ugrd.model;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * Created by Luyao on 2018/1/21.
 */

@Entity
public class Buginfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Timestamp deathTime;
    private Timestamp startTime;

    private double start_lat;
    private double start_lon;
    private double end_lat;
    private double end_lon;

    private boolean ifNeedStartTime;
    private boolean isMoved;

    private Integer lifecount;
    private String planter;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDeathTime(Timestamp deathTime) {
        this.deathTime = deathTime;
    }

    public Timestamp getDeathTime() {
        return deathTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStart_lat(double start_lat) {
        this.start_lat = start_lat;
    }

    public double getStart_lat() {
        return start_lat;
    }

    public void setStart_lon(double start_lon) {
        this.start_lon = start_lon;
    }

    public double getStart_lon() {
        return start_lon;
    }

    public void setEnd_lat(double end_lat) {
        this.end_lat = end_lat;
    }

    public double getEnd_lat() {
        return end_lat;
    }

    public void setEnd_lon(double end_lon) {
        this.end_lon = end_lon;
    }

    public double getEnd_lon() {
        return end_lon;
    }

    public void setIfNeedStartTime(boolean ifNeedStartTime) {
        this.ifNeedStartTime = ifNeedStartTime;
    }

    public boolean isIfNeedStartTime() {
        return ifNeedStartTime;
    }

    public void setIsMoved(boolean isMoved) {
        this.isMoved = isMoved;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setLifecount(Integer lifecount) {
        this.lifecount = lifecount;
    }

    public Integer getLifecount() {
        return lifecount;
    }

    public void setPlanter(String planter) {
        this.planter = planter;
    }

    public String getPlanter() {
        return planter;
    }
}
