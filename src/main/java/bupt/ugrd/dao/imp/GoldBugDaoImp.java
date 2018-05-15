package bupt.ugrd.dao.imp;

import bupt.ugrd.dao.GoldBugDao;
import bupt.ugrd.model.Buginfo2;
import bupt.ugrd.model.Debugrecord;
import bupt.ugrd.pojo.BugBasic;
import bupt.ugrd.pojo.BugCheck;
import bupt.ugrd.pojo.Result;
import bupt.ugrd.util.Constants;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Luyao on 2018/5/9.
 */

@Service
public class GoldBugDaoImp implements GoldBugDao{

    @Autowired
    private SessionFactory sessionFactory;



    @Transactional(readOnly = false)
    @Override
    public Result checkBug(int bugId, int type) {
        if(type != 0 && type != 1)
            return new Result(false, "访问后台失败", 1, true,null);

        try {
            // type == 0 允许发布  resOfCheck == 0
            // type == 1 驳回      resOfCheck == 1
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("UPDATE buginfo2 SET res_of_check =? WHERE bug_id_id =?")
                    .setParameter(0, type)
                    .setParameter(1, bugId);
            query.executeUpdate();
            session.getTransaction().commit();

        }catch (Exception ex){
            return new Result(false, "审核结果保存失败", 1, true,null);
        }

        return new Result(true, "审核结果提交成功", 0, true,null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BugCheck> getBuginfoForCheck(int type) {
        int status = 0;
        List<BugCheck> bugCheckList = new ArrayList<>();
        if(type != 0 && type != 1){
            return bugCheckList;
        }

        if(type == 0){ // 待审核
            status = -1;
        }
        if (type == 1){ // 已审核通过
            status = 0;
        }
        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t2.bug_id_id, t.question, t.key_ FROM content t,buginfo2 t2 WHERE t2.res_of_check =? AND t.bug_id = t2.bug_id_id AND t2.status =?")
                .setParameter(0, status)
                .setParameter(1, 0)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size() == 0){
            return bugCheckList;
        }
        else {
            for(int i = 0; i< res.size();i++){

                Map map = (Map)res.get(i);

                BugCheck bugCheck = new BugCheck();
                bugCheck.setBugId((int)map.get("bug_id_id"));
                bugCheck.setQuestion((String)map.get("question"));
                bugCheck.setKey_((String)map.get("key_"));
                bugCheckList.add(bugCheck);
            }
            return bugCheckList;
        }

    }


    @Transactional(readOnly = true)
    @Override
    public List<BugBasic> getAroungBugs(double userLon, double userLat, int userId) {
        List<BugBasic> bugList = new ArrayList<>();

        int status = 0;
        double minLon = userLon - 5; double maxLon = userLon + 5;
        double minLat = userLat - 5; double maxLat = userLat + 5; //
        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t2.lon, t2.lat, t2.bug_id_id,t2.ar_index FROM buginfo2 t2 WHERE t2.status =? AND t2.lon >=? AND  t2.lon <=? AND t2.lat >=? AND t2.lat <=? AND t2.res_of_check =?")
                .setParameter(0, status)
                .setParameter(1, minLon)
                .setParameter(2, maxLon)
                .setParameter(3, minLat)
                .setParameter(4, maxLat)
                .setParameter(5, status)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size() == 0){
            return null;
        }
        else {
            for(int i = 0; i < res.size(); i++){
                Map map = (Map)res.get(i);

                int bugId = (int)map.get("bug_id_id");
                double lon = (double)map.get("lon");
                double lat = (double)map.get("lat");

                BugBasic bugBasic = new BugBasic();
                bugBasic.setLon(lon);
                bugBasic.setLat(lat);
                bugBasic.setBugId(bugId);

                if(map.get("ar_index")!=null){
                    bugBasic.setArIndex((int)map.get("ar_index"));
                }
                else {
                    bugBasic.setArIndex(-1);
                }

                //计算type值
                if(this.getDebugRecord(bugId, userId) != null){
                    if(this.getDebugRecord(bugId, userId).getState() == 0){
                        bugBasic.setType(1); // 已经成功回答过 1 light
                    }
                }
                else {
                    if(Math.abs(lat - userLat) <= Constants.MIN_LAT_DISTANCE && Math.abs(lon - userLon) <= Constants.MIN_LON_DISTANCE){
                        bugBasic.setType(0); // 在附近可以答题范围内 && 未回答的 0  active
                    }
                    else {
                        bugBasic.setType(2); // 不在可答题范围内的&&未回答的 2  non-active
                    }
                }

                bugList.add(bugBasic);
            }
            return bugList;
        }
    }


    @Transactional(readOnly = true)
    @Override
    public Debugrecord getDebugRecord(int bugId, int userId) {
        Debugrecord debugrecord = new Debugrecord();

        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t2.state FROM debugrecord t2 WHERE t2.bug_id =? AND t2.user_id =?")
                .setParameter(0, bugId)
                .setParameter(1, userId)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size() == 0){
            return null;
        }
        else {
            int state = 1; // 1 失败 0 成功
            for(int i =0;i<res.size();i++) {
                Map map = (Map) res.get(i);
                int t_state = (int)map.get("state");
                if(t_state == 0){
                    state = 0;
                }
            }
            debugrecord.setState(state);
            return debugrecord;
        }
    }


    @Transactional(readOnly = true)
    @Override
    public Buginfo2 getBuginfo2ByBugId(int bugId) {
        int status = 0;
        Buginfo2 buginfo2 = new Buginfo2();

        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t2.id,t2.status, t2.lon, t2.lat, t2.lifecount, t2.ar_index, t2.res_of_check FROM buginfo2 t2 WHERE t2.bug_id_id =?")
                .setParameter(0, bugId)
                //.setParameter(1, status)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size() == 0){
            return null;
        }
        else {
            Map map = (Map)res.get(0);
            buginfo2.setId((int)map.get("id"));

            buginfo2.setStatus((Integer)map.get("status"));
            buginfo2.setLon((double)map.get("lon"));
            buginfo2.setLat((double)map.get("lat"));
            buginfo2.setLifecount((int)map.get("lifecount"));
            buginfo2.setResOfCheck((int)map.get("res_of_check"));

            if(map.get("ar_index")!=null){
                buginfo2.setArIndex((Integer)map.get("ar_index"));
            }
            else {
                buginfo2.setArIndex(-1);
            }
            return buginfo2;
        }
    }
}
