package bupt.ugrd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Luyao on 2018/1/21.
 */
@Entity
public class Content {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Integer id;
    private Integer bugId;

    private Integer contentType;
    private String description;
    private String question;
    private double score;
    private String ans_1;
    private String ans_2;
    private String ans_3;
    private String ans_4;
    private String key_;

/*
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }*/

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public Integer getBugId() {
        return bugId;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAns_1() {
        return ans_1;
    }

    public void setAns_1(String ans_1) {
        this.ans_1 = ans_1;
    }

    public String getAns_2() {
        return ans_2;
    }

    public void setAns_2(String ans_2) {
        this.ans_2 = ans_2;
    }

    public String getAns_3() {
        return ans_3;
    }

    public void setAns_3(String ans_3) {
        this.ans_3 = ans_3;
    }

    public String getAns_4() {
        return ans_4;
    }

    public void setAns_4(String ans_4) {
        this.ans_4 = ans_4;
    }

    public String getKey_() {
        return key_;
    }

    public void setKey_(String key_) {
        this.key_ = key_;
    }

}
