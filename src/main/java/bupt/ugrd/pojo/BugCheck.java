package bupt.ugrd.pojo;

import java.io.Serializable;

/**
 * Created by Luyao on 2018/5/10.
 */
public class BugCheck implements Serializable {
    private int bugId;
    private int type;
    private String question;
    private String key_;

    public BugCheck(){}

    public BugCheck(int bugId, int type, String question, String key_){
        this.bugId = bugId;
        this.type = type;
        this.question = question;
        this.key_ = key_;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public int getBugId() {
        return bugId;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public String getKey_() {
        return key_;
    }

    public void setKey_(String key_) {
        this.key_ = key_;
    }
}
