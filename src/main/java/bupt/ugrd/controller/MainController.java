package bupt.ugrd.controller;

/**
 * Created by Luyao on 2018/1/20.
 */

//import bupt.ugrd.model.Buginfo;
//import bupt.ugrd.model.BuginfoRepository;
import bupt.ugrd.model.*;
import bupt.ugrd.pojo.*;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Iterator;


//@Controller
@RestController
@RequestMapping("/goldbug")
public class MainController {
    @Autowired // This means to get the bean called userinfoRepositor which is auto-generated by Spring, we will use it to handle the data
    private UserinfoRepository userinfoRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private TimechangeRepository timechangeRepository;

    @Autowired
    private PoschangeRepository poschangeRepository;

    @Autowired
    private BuginfoRepository buginfoRepository;

    @RequestMapping("addUser")
    public @ResponseBody Result addNewUser(@RequestBody User user){
        Userinfo n = new Userinfo(user.getUserPhone(), user.getUserName());
        userinfoRepository.save(n);
        return new Result(true, "success", 0);
    }

    public Userinfo findUserByName(String userName) {
        Iterable<Userinfo> users = userinfoRepository.findAll();
        Iterator<Userinfo> it= users.iterator();

        while(it.hasNext()){
            Userinfo user = it.next();
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    public Timechange findTimeChangeById(Integer id){
        Iterable<Timechange> timechanges = timechangeRepository.findAll();
        Iterator<Timechange> it= timechanges.iterator();

        while(it.hasNext()){
            Timechange timechange = it.next();
            if(timechange.getId().equals(id)){
                return timechange;
            }
        }
        return null;
    }

    public Poschange findPosChangeById(Integer id){
        Iterable<Poschange> poschanges = poschangeRepository.findAll();
        Iterator<Poschange> it= poschanges.iterator();

        while(it.hasNext()){
            Poschange poschange = it.next();
            if(poschange.getId().equals(id)){
                return poschange;
            }
        }
        return null;
    }

    @RequestMapping("addGoldbug") //@RequestBody BugInfo bugInfo, @RequestBody Content content
    public @ResponseBody Result addNewGoldbug(@RequestBody BugContent bugContent){
        BugInfo bugInfo = bugContent.getBugInfo();
        bupt.ugrd.pojo.Content content = bugContent.getContent();

        bupt.ugrd.model.Content cont = new bupt.ugrd.model.Content();
        cont.setDescription(content.getDescription());
        cont.setQuestion(content.getQuestion());
        cont.setScore(content.getScore());
        cont.setAns_1(content.getAns_1());
        cont.setAns_2(content.getAns_2());
        cont.setAns_3(content.getAns_3());
        cont.setAns_4(content.getAns_4());
        cont.setContentType(content.getContentType());
        //  cont.setKey(cont.getKey());
        contentRepository.save(cont);

        Buginfo bug = new Buginfo();
        String userName = bugInfo.getPlanter();
        Userinfo user = this.findUserByName(userName);

        Timechange timechange = this.findTimeChangeById(bugInfo.getTimeIndex());
        Poschange poschange = this.findPosChangeById(bugInfo.getPosIndex());

        double p1, p2, p3;
        if(user!=null && timechange!=null && poschange!=null){
            bug.setUserinfo(user);
            bug.setPlanter(userName);

            bug.setTimechange(timechange);
            p1 = bugInfo.getTimeP_1();
            p2 = bugInfo.getTimeP_2();
            if(p1!=-1)
                bug.setTimeP_1(p1);
            if (p2!=-1)
                bug.setTimeP_2(p2);

            bug.setPoschange(poschange);
            p1 = bugInfo.getPosP_1();
            p2 = bugInfo.getPosP_2();
            p3 = bugInfo.getPosP_3();
            if(p1!=-1)
                bug.setPosP_1(p1);
            if (p2!=-1)
                bug.setPosP_2(p2);
            if(p3!=-1)
                bug.setPosP_3(p3);
            bug.setContent(cont);
           // bug.setBrithTime(bugInfo.getBirthTime());
           // bug.setDeathTime(bugInfo.getDeathTime());
            buginfoRepository.save(bug);
            return new Result(true, "success", 0);
        }
        return new Result(false, "failure", 1);
    }



}
