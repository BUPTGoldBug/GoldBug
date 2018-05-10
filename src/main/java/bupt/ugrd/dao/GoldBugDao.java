package bupt.ugrd.dao;

import bupt.ugrd.model.Buginfo2;
import bupt.ugrd.model.Debugrecord;
import bupt.ugrd.pojo.BugBasic;
import bupt.ugrd.pojo.BugCheck;
import bupt.ugrd.pojo.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Luyao on 2018/5/9.
 */

@Service
public interface GoldBugDao {

    Buginfo2 getBuginfo2ByBugId(int bugId);

    Debugrecord getDebugRecord(int bugId, int userId);

    List<BugBasic> getAroungBugs(double userLon, double userLat);

    List<BugCheck> getBuginfoForCheck(int type);

    Result checkBug(int bugId, int type);
}
