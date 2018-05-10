package bupt.ugrd.controller;

import bupt.ugrd.dao.GoldBugDao;
import bupt.ugrd.pojo.BugCheck;
import bupt.ugrd.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Luyao on 2018/5/10.
 */

@RestController
@RequestMapping("/superuser")
public class SuperUserController {

    @Autowired
    private GoldBugDao goldBugDaoImp;


    @RequestMapping("/getBugList")
    public @ResponseBody List<BugCheck> getBugList(@RequestBody BugCheck bugCheck){
        // type 0 待审核 1 已审核通过
        List<BugCheck> bugCheckList = goldBugDaoImp.getBuginfoForCheck(bugCheck.getType());
        return bugCheckList;
    }

    @RequestMapping("/checkBug")
    public @ResponseBody Result checkBug(@RequestBody BugCheck bugCheck){
        // type 0 允许发布 1 驳回
        return goldBugDaoImp.checkBug(bugCheck.getBugId(), bugCheck.getType());
    }


}
