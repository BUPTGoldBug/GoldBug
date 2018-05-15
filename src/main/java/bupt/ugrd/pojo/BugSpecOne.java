package bupt.ugrd.pojo;

import java.util.ArrayList;
import java.util.List;

public class BugSpecOne {

    private  String question;
    private List<String> answer =new ArrayList<String>();
    private  int arIndex;
    private  int bugId;
    private  boolean success;
    private int lifecount;
    private double score;
    private String des;
    private String key_;

    public BugSpecOne(){
        success = false;

    }

    public int getArIndex() {
        return arIndex;
    }

    public void setArIndex(int arIndex) {
        this.arIndex = arIndex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }


    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setLifecount(int lifecount) {
        this.lifecount = lifecount;
    }

    public int getLifecount() {
        return lifecount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setKey_(String key_) {
        this.key_ = key_;
    }

    public String getKey_() {
        return key_;
    }
}
