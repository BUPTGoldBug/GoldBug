package bupt.ugrd.controller;

import bupt.ugrd.dao.UserDao;
import bupt.ugrd.model.Userinfo;
import bupt.ugrd.model.Userinfo2;
import bupt.ugrd.model.Userinfo2Repository;
import bupt.ugrd.model.UserinfoRepository;
import bupt.ugrd.pojo.Common;
import bupt.ugrd.pojo.Result;
import bupt.ugrd.pojo.User;
import bupt.ugrd.pojo.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Luyao on 2018/4/26.
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    // This means to get the bean called userinfoRepositor which is auto-generated by Spring, we will use it to handle the data
    private UserinfoRepository userinfoRepository;

    @Autowired
    private Userinfo2Repository userinfo2Repository;

    @Autowired
    private UserDao userDaoImp;

    @RequestMapping("/login")
    public @ResponseBody Result login(@RequestBody User user){
        boolean canLogin = userDaoImp.verifyUser(user.getUserName(), user.getPassword());
        if(!canLogin){
            return new Result(false,"用户名或密码错误",1, false, null);
        }
        else {
            UserDetail userDetail = userDaoImp.getUserDetailByUserName(user.getUserName());
            if(userDetail.isSuccess() == false){
                return new Result(false,"用户不存在",1, false, null);
            }
            else {
                if(user.getUserName().equals("admin"))
                    return new Result(true,"欢迎管理员登陆",0, true, userDetail);
                else
                    return new Result(true,"登陆成功",0, false, userDetail);
            }

        }
    }

/*
    @RequestMapping("/login")
    public @ResponseBody Result login(@RequestBody Common common, HttpServletRequest req,HttpServletResponse res){
        int i= userDaoImp.testUser(common.getUserName(),common.getPassWord());
        if(i == 0 ){
            return new Result(false,"没有此人",0);
        }
        Userinfo userinfo = userDaoImp.getUser(common.getUserName(),common.getPassWord());
        Cookie cookie = new Cookie("userId",userinfo.getId()+"");
        cookie.setMaxAge(60*60*24*30);//30天
        res.addCookie(cookie);

        UserDetail userDetail = userDaoImp.getUserDetail(common.getUserName(),common.getPassWord());
        Result result =new Result(false,"没有此人",0);
        if(userDetail == null)return result;
        result.setSuccess(true);
        result.setUserDetail(userDetail);
        return result;
    }
    */

    @RequestMapping("/getDetail")
    public @ResponseBody
    UserDetail getDetail(@RequestBody Common common){
        int uid = common.getUserId();
        UserDetail userDetail =  userDaoImp.getUserDetailByUid(uid);
        return userDetail;

    }

    @RequestMapping("addUser")
    public @ResponseBody Result addNewUser(@RequestBody User user){
        if(!userDaoImp.ifUserNameExist(user.getUserName())){
            Userinfo newUser = new Userinfo(user.getUserPhone(), user.getUserName(), user.getCreateTime(), user.getPassword());
            userinfoRepository.save(newUser);

            Userinfo2 userinfo2 = new Userinfo2();
            userinfo2.setUserId(newUser.getId());
            userinfo2Repository.save(userinfo2);

            return new Result(true, "success", 0, false, null);
        }
        return new Result(false, "User Name Already Existed!", 1, false, null);

    }



}
