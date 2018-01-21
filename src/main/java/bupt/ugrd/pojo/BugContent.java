package bupt.ugrd.pojo;

import java.io.Serializable;

/**
 * Created by Luyao on 2018/1/21.
 */
public class BugContent implements Serializable{
    private BugInfo bugInfo;
    private Content content;

    public BugContent(){}

    public BugContent(BugInfo bugInfo, Content content){
        this.bugInfo = bugInfo;
        this.content = content;
    }

    public BugInfo getBugInfo() {
        return bugInfo;
    }

    public void setBugInfo(BugInfo bugInfo) {
        this.bugInfo = bugInfo;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
