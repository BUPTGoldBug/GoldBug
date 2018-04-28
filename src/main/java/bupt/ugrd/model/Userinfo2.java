package bupt.ugrd.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Luyao on 2018/4/28.
 */
@Entity
public class Userinfo2 {
    @Id
    private Integer userId;

    private double score;

    public Userinfo2(){}

    public Userinfo2(Integer userId, double score){
        this.userId = userId;
        this.score = score;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
