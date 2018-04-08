package bupt.ugrd.controller;

import bupt.ugrd.model.Buginfo;
import bupt.ugrd.model.Buginfo2;
import bupt.ugrd.model.Buginfo2Repository;
import bupt.ugrd.model.BuginfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Luyao on 2018/4/8.
 */

@Component
public class Scheduler {

    @Autowired
    private BuginfoRepository buginfoRepository;

    @Autowired
    private Buginfo2Repository buginfo2Repository;

    @Scheduled(fixedRate = 5000)//每5秒执行一次
    public void play() throws Exception {
        Integer status = -1;
        double lon = 0, lat = 0;
        int lifecount;
        Buginfo bugId;

        System.out.println("执行Quartz定时器任务 -Start- ："+new Date());

        Iterable<Buginfo2> bugs = buginfo2Repository.findAll();

        for(Buginfo2 bug : bugs){
            bugId = bug.getBugId();
            Integer id = bugId.getId();

            Buginfo buginfo = buginfoRepository.findOne(id);

            lifecount = bug.getLifecount();

            Timestamp nowTime = new Timestamp(new Date().getTime());
            if(!buginfo.isMoved()){ // 虫子静止
                lon = buginfo.getStart_lon();
                lat = buginfo.getStart_lat();

                // 现在开始可一直被捉
                if(!buginfo.isIfNeedStartTime()){
                    if (lifecount > 0 && nowTime.before(buginfo.getDeathTime())){
                        lifecount --; // 模拟捉虫！！！！！！
                        status = 0;
                    }
                    else {
                        status = 2;
                    }
                }
                // 有预设开始时间点
                else {
                    if(nowTime.before(buginfo.getStartTime())){
                        status = 1;
                    }
                    else {
                        if(nowTime.after(buginfo.getStartTime()) && nowTime.before(buginfo.getDeathTime()) && lifecount > 0){
                            status = 0;
                        }
                        else if(nowTime.after(buginfo.getDeathTime()) || lifecount <= 0){
                            status = 2;
                        }
                        else
                            status = -1;
                    }
                }
            }
            else { // 虫子移动
                if(!buginfo.isIfNeedStartTime()){ // 现在开始可一直被捉

                }
                else {

                }

            }

            bug.setLifecount(lifecount); // 模拟捉虫！！！！！！！！
            bug.setLon(lon);
            bug.setLat(lat);
            bug.setStatus(status);
          //  newBug.setBugId(bugId);
            buginfo2Repository.save(bug);

        }

        System.out.println("执行Quartz定时器任务 -End- ："+new Date());
    }
}
