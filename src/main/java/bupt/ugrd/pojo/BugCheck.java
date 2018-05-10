package bupt.ugrd.pojo;

import java.io.Serializable;

/**
 * Created by Luyao on 2018/5/10.
 */
public class BugCheck implements Serializable {
    private int bugId;
    private int type;
    private String question;

    public BugCheck(){}

    public BugCheck(int bugId, int type, String question){
        this.bugId = bugId;
        this.type = type;
        this.question = question;
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
}
