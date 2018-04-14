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

    private static final double MOVE_DIS = 0.00001; // 大约1米左右

    @Autowired
    private BuginfoRepository buginfoRepository;

    @Autowired
    private Buginfo2Repository buginfo2Repository;

    @Scheduled(fixedRate = 5000)//每5秒执行一次
    public void play() throws Exception {
        Integer status = -2;
        double lon = 0, lat = 0;
        int lifecount;
        Buginfo bugId;

        System.out.println("执行Quartz定时器任务 -Start- ："+new Date());

        Iterable<Buginfo2> bugs = buginfo2Repository.findAll();

        for(Buginfo2 bug : bugs){
            lifecount = bug.getLifecount(); // 模拟捉虫！！！！！！！！
            bugId = bug.getBugId();
            Integer id = bugId.getId();

            Buginfo buginfo = buginfoRepository.findOne(id);

            if(bug.getStatus() == -1){
                lon = buginfo.getStart_lon();
                lat = buginfo.getStart_lat();
            }
            else {
                lon = bug.getLon();
                lat = bug.getLat();
            }

            Timestamp nowTime = new Timestamp(new Date().getTime());
            if(!buginfo.isMoved()){ // 虫子静止

                // 现在开始可一直被捉
                if(!buginfo.isIfNeedStartTime()){
                    if (lifecount > 0 && nowTime.before(buginfo.getDeathTime())){
                        //lifecount --; // 模拟捉虫！！！！！！
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
                            //lifecount--;
                            status = 0;
                        }
                        else if(nowTime.after(buginfo.getDeathTime()) || lifecount <= 0){
                            status = 2;
                        }
                        else
                            status = -2;
                    }
                }
            }
            else { // 虫子移动

                double e_lon = buginfo.getEnd_lon();
                double e_lat = buginfo.getEnd_lat();
                double line = Math.sqrt(Math.pow((e_lon-lon), 2) + Math.pow((e_lat-lat), 2));
                double lon_dis = MOVE_DIS * Math.abs(e_lon - lon) / line;
                double lat_dis = MOVE_DIS * Math.abs(e_lat - lat) / line;

                if(!buginfo.isIfNeedStartTime()){ // 现在开始可一直被捉
                    if (lifecount > 0 && nowTime.before(buginfo.getDeathTime())){

                        if(e_lon > lon) lon += lon_dis;
                        else lon -= lon_dis;
                        if(e_lat > lat) lat += lat_dis;
                        else lat -= lat_dis;
                        lifecount --; // 模拟捉虫！！！！！！

                        status = 0;
                    }
                    else {
                        status = 2;
                    }
                }
                else {
                    if(nowTime.before(buginfo.getStartTime())){
                        status = 1;
                    }
                    else {
                        if(nowTime.after(buginfo.getStartTime()) && nowTime.before(buginfo.getDeathTime()) && lifecount > 0){
                            lifecount--; // 模拟捉虫！！！！！！
                            if(e_lon > lon) lon += lon_dis;
                            else lon -= lon_dis;
                            if(e_lat > lat) lat += lat_dis;
                            else lat -= lat_dis;
                            status = 0;
                        }
                        else if(nowTime.after(buginfo.getDeathTime()) || lifecount <= 0){
                            status = 2;
                        }
                        else
                            status = -2;
                    }
                }

            }

            bug.setLifecount(lifecount); // 模拟捉虫！！！！！！！！
            bug.setLon(lon);
            bug.setLat(lat);
            bug.setStatus(status);
            buginfo2Repository.save(bug);

        }

        System.out.println("执行Quartz定时器任务 -End- ："+new Date());
    }
}
