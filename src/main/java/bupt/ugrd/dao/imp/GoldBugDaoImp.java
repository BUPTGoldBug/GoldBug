package bupt.ugrd.dao.imp;

import bupt.ugrd.dao.GoldBugDao;
import bupt.ugrd.model.Buginfo2;
import bupt.ugrd.model.Debugrecord;
import bupt.ugrd.pojo.BugBasic;
import org.hibernate.Query;
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


    @Transactional(readOnly = true)
    @Override
    public List<BugBasic> getAroungBugs(double userLon, double userLat) {
        List<BugBasic> bugList = new ArrayList<>();

        int status = 0;
        double minLon = userLon - 5; double maxLon = userLon + 5;
        double minLat = userLat - 5; double maxLat = userLat + 5; //
        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t2.lon, t2.lat, t2.bug_id_id,t2.ar_index FROM buginfo2 t2 WHERE t2.status =? AND t2.lon >=? AND  t2.lon <=? AND t2.lat >=? AND t2.lat <=? ")
                .setParameter(0,status)
                .setParameter(1, minLon)
                .setParameter(2, maxLon)
                .setParameter(3, minLat)
                .setParameter(4, maxLat)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size() == 0){
            return null;
        }
        else {
            for(int i = 0; i < res.size(); i++){
                Map map = (Map)res.get(i);

                BugBasic bugBasic = new BugBasic();
                bugBasic.setLon((double)map.get("lon"));
                bugBasic.setLat((double)map.get("lat"));
                bugBasic.setBugId((int)map.get("bug_id_id"));
                if(map.get("ar_index")!=null){
                    bugBasic.setArIndex((int)map.get("ar_index"));
                }
                else {
                    bugBasic.setArIndex(-1);
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
            Map map = (Map)res.get(0);
            debugrecord.setState((int)map.get("state"));
            return debugrecord;
        }
    }


    @Transactional(readOnly = true)
    @Override
    public Buginfo2 getBuginfo2ByBugId(int bugId) {
        Buginfo2 buginfo2 = new Buginfo2();

        Query query1 = sessionFactory.getCurrentSession().createSQLQuery("SELECT t2.status, t2.lon, t2.lat, t2.lifecount, t2.ar_index FROM buginfo2 t2 WHERE t2.bug_id_id =?")
                .setParameter(0, bugId) .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List res = query1.list();
        if(res.size() == 0){
            return null;
        }
        else {
            Map map = (Map)res.get(0);
            buginfo2.setStatus((Integer)map.get("status"));
            buginfo2.setLon((double)map.get("lon"));
            buginfo2.setLat((double)map.get("lat"));
            buginfo2.setLifecount((int)map.get("lifecount"));
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
