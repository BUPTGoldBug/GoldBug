package bupt.ugrd.model;

import bupt.ugrd.model.Content;
import bupt.ugrd.model.Poschange;
import bupt.ugrd.model.Timechange;
import bupt.ugrd.model.Userinfo;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by Luyao on 2018/1/21.
 */

@Entity
public class Buginfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = Userinfo.class)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Userinfo userinfo;

    private String planter;

    @ManyToOne(targetEntity = Timechange.class)
    @JoinColumn(name = "timeIndex", referencedColumnName = "id")
    private Timechange timechange;

    private double timeP_1;

    private double timeP_2;

    @ManyToOne(targetEntity = Poschange.class)
    @JoinColumn(name = "posIndex", referencedColumnName = "id")
    private Poschange poschange;

    private double posP_1;

    private double posP_2;

    private double posP_3;

    @ManyToOne(targetEntity = Content.class)
    @JoinColumn(name = "contentIndex", referencedColumnName = "id")
    private Content content;

 //   private Date birthTime;

 //   private Data deathTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public String getPlanter() {
        return planter;
    }

    public void setPlanter(String planter) {
        this.planter = planter;
    }

    public Timechange getTimechange() {
        return timechange;
    }

    public void setTimechange(Timechange timechange) {
        this.timechange = timechange;
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

    public Poschange getPoschange() {
        return poschange;
    }

    public void setPoschange(Poschange poschange) {
        this.poschange = poschange;
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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
/*
    public Date getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public Data getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(Data deathTime) {
        this.deathTime = deathTime;
    }*/
}
