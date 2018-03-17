package bupt.ugrd.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * Created by Luyao on 2018/1/21.
 */
public class BugInfo implements Serializable{
    private double lon;
    private double lat;
    private Integer lifecount;
    private String planter;
    private Integer timeIndex;
    private double timeP_1;
    private double timeP_2;
    private Integer posIndex;
    private double posP_1;
    private double posP_2;
    private double posP_3;

 //   private Data birthTime;
 //   private Data deathTime;

    public BugInfo(){}

    public BugInfo( double lon, double lat, Integer lifecount, String planter, Integer timeIndex, double timeP_1,double timeP_2,Integer posIndex, double posP_1,double posP_2, double posP_3){
        this.lon = lon;
        this.lat = lat;
        this.lifecount = lifecount;
        this.planter = planter;
        this.timeIndex = timeIndex;
        this.timeP_1 = timeP_1;
        this.timeP_2 = timeP_2;
        this.posIndex = posIndex;
        this.posP_1 = posP_1;
        this.posP_2 = posP_2;
        this.posP_3 = posP_3;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLon() {
        return lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
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

    public void setTimeIndex(Integer timeIndex) {
        this.timeIndex = timeIndex;
    }

    public Integer getTimeIndex() {
        return timeIndex;
    }

    public void setTimeP_1(double timeP_1) {
        this.timeP_1 = timeP_1;
    }

    public double getTimeP_1() {
        return timeP_1;
    }

    public void setTimeP_2(double timeP_2) {
        this.timeP_2 = timeP_2;
    }

    public double getTimeP_2() {
        return timeP_2;
    }

    public void setPosIndex(Integer posIndex) {
        this.posIndex = posIndex;
    }

    public Integer getPosIndex() {
        return posIndex;
    }

    public void setPosP_1(double posP_1) {
        this.posP_1 = posP_1;
    }

    public double getPosP_1() {
        return posP_1;
    }

    public void setPosP_2(double posP_2) {
        this.posP_2 = posP_2;
    }

    public double getPosP_2() {
        return posP_2;
    }

    public void setPosP_3(double posP_3) {
        this.posP_3 = posP_3;
    }

    public double getPosP_3() {
        return posP_3;
    }

/*
    public void setBirthTime(Data birthTime) {
        this.birthTime = birthTime;
    }

    public Data getBirthTime() {
        return birthTime;
    }

    public void setDeathTime(Data deathTime) {
        this.deathTime = deathTime;
    }

    public Data getDeathTime() {
        return deathTime;
    }*/
}
