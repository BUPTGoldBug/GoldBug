package bupt.ugrd.dao.imp;

import bupt.ugrd.dao.UserDao;
import bupt.ugrd.pojo.UserDetail;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Luyao on 2018/5/8.
 */

@Service
public class UserDaoImp implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;



    @Transactional(readOnly = true)
    @Override
    public boolean verifyUser(String userName, String password) {
        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t2.user_phone FROM userinfo t2 WHERE t2.user_name =? AND t2.password =?")
                .setParameter(0, userName)
                .setParameter(1, password)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size()==0)return false;
        else  return true;

    }


    @Transactional(readOnly = true)
    @Override
    public boolean ifUserNameExist(String userName) {
        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t2.user_phone FROM userinfo t2 WHERE t2.user_name =?")
                .setParameter(0, userName) .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size() == 0){
            return false;
        }
        return true;
    }


    @Transactional(readOnly = true)
    @Override
    public UserDetail getUserDetailByUserName(String userName) {
        UserDetail userDetail = new UserDetail();

        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t.user_id, t.score, t2.user_phone, t2.user_name FROM userinfo2 t,userinfo t2 WHERE t2.user_name =? AND t.user_id = t2.id")
                .setParameter(0, userName) .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size() == 0){
            userDetail.setSuccess(false);
        }
        else {

            Map map = (Map)res.get(0);
            userDetail.setUserId((int)map.get("user_id"));
            userDetail.setScore((double)map.get("score"));
            userDetail.setUserName((String)map.get("user_name"));
            userDetail.setUserPhone((String)map.get("user_phone"));

            userDetail.setSuccess(true);
        }

        return  userDetail;

    }


    @Transactional(readOnly = true)
    @Override
    public UserDetail getUserDetailByUid(int uid) {
        UserDetail userDetail = new UserDetail();

        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t.user_id, t.score, t2.user_phone, t2.user_name FROM userinfo2 t,userinfo t2 WHERE t.user_id =? AND t2.id=t.user_id")
                .setParameter(0, uid) .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size() == 0){
            userDetail.setSuccess(false);
        }
        else {
            userDetail.setSuccess(true);
            Map map = (Map)res.get(0);
            userDetail.setUserId((int)map.get("user_id"));
            userDetail.setScore((double)map.get("score"));
            userDetail.setUserName((String)map.get("user_name"));
            userDetail.setUserPhone((String)map.get("user_phone"));
        }

        return  userDetail;

/*
        Object[] i =(Object[]) query.uniqueResult();
        UserDetail result = new UserDetail();
        if( i == null){
            result.setSuccess(false);

        }else {
            result.setScore(((Double)i[0]).intValue());
            result.setUserId((Integer) i[3]);
            result.setUserName((String) i[1]);
            result.setUserPhone((String) i[2]);
            result.setSuccess(true);
        }
        return result;*/
    }

}
