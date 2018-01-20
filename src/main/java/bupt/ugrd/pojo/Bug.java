package bupt.ugrd.pojo;

/**
 * Created by Luyao on 2018/1/20.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Bug {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String planter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanter() {
        return planter;
    }

    public void setPlanter(String planter) {
        this.planter = planter;
    }


}