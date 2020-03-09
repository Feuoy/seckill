package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*
 * 配置spring与junit整合，junit启动加载springIOC容器
 * ctrl+shift+t创建
 * */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {


    /*注入dao实现类*/
    @Resource
    private SeckillDao seckillDao;


    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }
    /*
    * 1000元秒杀iPhone
        Seckill{
        * seckillID=1000,
        * name=1000元秒杀iPhone,
        * number=10,
        * startTime=Tue Aug 22 08:00:00 CST 2017,
        * endTime=Tue Aug 22 18:00:00 CST 2017,
        * createTime=Sat Sep 07 04:54:54 CST 2019}
* */

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.println("seckill:" + seckill);
        }
    }
    /*
    * seckill:Seckill{seckillID=1000, name=1000元秒杀iPhone, number=10, startTime=Tue Aug 22 08:00:00 CST 2017, endTime=Tue Aug 22 18:00:00 CST 2017, createTime=Sat Sep 07 04:54:54 CST 2019}
        seckill:Seckill{seckillID=1001, name=500元秒杀iPad2, number=20, startTime=Tue Aug 22 08:00:00 CST 2017, endTime=Tue Aug 22 18:00:00 CST 2017, createTime=Sat Sep 07 04:54:54 CST 2019}
        seckill:Seckill{seckillID=1002, name=400元秒杀小米4, number=30, startTime=Tue Aug 22 08:00:00 CST 2017, endTime=Tue Aug 22 18:00:00 CST 2017, createTime=Sat Sep 07 04:54:54 CST 2019}
        seckill:Seckill{seckillID=1003, name=300元秒杀三星, number=40, startTime=Tue Aug 22 08:00:00 CST 2017, endTime=Tue Aug 22 18:00:00 CST 2017, createTime=Sat Sep 07 04:54:54 CST 2019}
        seckill:Seckill{seckillID=1004, name=200元秒杀华为, number=50, startTime=Tue Aug 22 08:00:00 CST 2017, endTime=Tue Aug 22 18:00:00 CST 2017, createTime=Sat Sep 07 04:54:54 CST 2019}

* */


    @Test
    public void reduceNumber() throws Exception {
        Date killDate = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killDate);
        System.out.println("updateCount:" + updateCount);
    }
//    10:53:50.379 [main] DEBUG o.s.dao.SeckillDao.reduceNumber - ==>  Preparing:
//    update seckill
//    set `number` =`number` - 1
//    where seckill_id = ?
//    and start_time < ?
//    and end_time >= ?
//    and `number` > 0
//            10:53:50.463 [main] DEBUG o.s.dao.SeckillDao.reduceNumber - ==> Parameters:
//            1000(Long),
//            2019-09-07 10:53:49.36(Timestamp),
//            2019-09-07 10:53:49.36(Timestamp)
//            10:53:50.466 [main] DEBUG o.s.dao.SeckillDao.reduceNumber - <==
//            Updates: 0

}
