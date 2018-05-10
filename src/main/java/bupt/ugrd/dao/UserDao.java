package bupt.ugrd.dao;

import bupt.ugrd.pojo.UserDetail;
import org.springframework.stereotype.Service;

/**
 * Created by Luyao on 2018/5/8.
 */

@Service
public interface UserDao {

    UserDetail getUserDetailByUid(int uid);

    UserDetail getUserDetailByUserName(String userName);

    boolean ifUserNameExist(String userName);

    boolean verifyUser(String userName, String password);

}
