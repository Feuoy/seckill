package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-services.xml"
})
public class SeckillServiceTest {



    private static final Logger LOGGER = LoggerFactory.getLogger(SeckillServiceTest.class);

    @Autowired
    private SeckillService seckillService;



    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        LOGGER.info("list:{}", list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        LOGGER.info("seckill:{}", seckill);
    }



/*    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        LOGGER.info("exposer:{}", exposer);
    }
*//*    Exposer{exposed=false,
            md5=null,
            seckillId=1000,
            now=1567842488730,
            start=1503360000000,
            end=1503396000000}*//*


    //  md5 = null问题，上面的test也是
    @Test
    public void executeSeckill() throws Exception {
        long id = 1001;
        long phone = 18700000000L;
        String md5 = "2ce058181f12dec7676776584c2e6db4";
//        String md5 = null;
        SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
        LOGGER.info("result:{}", seckillExecution);
    }*/






    // 有时候连接数据库问题
    @Test
    public void seckillLogic() {
        long id = 1002;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            LOGGER.info("exposer:{}", exposer);
            long phone = 18700000000L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
                LOGGER.info("result:{}", seckillExecution);
            } catch (SeckillCloseException e) {
                LOGGER.error(e.getMessage());
            } catch (RepeatKillException e) {
                LOGGER.error(e.getMessage());
            } catch (SeckillException e) {
                LOGGER.error(e.getMessage());
            }
        } else {
//            LOGGER.info("exposer:{}", exposer);
            LOGGER.warn("exposer:{}", exposer);
        }
    }
/*
    16:07:40.173 [main] DEBUG o.m.s.t.SpringManagedTransaction - JDBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@4a3631f8] will not be managed by Spring
16:07:40.232 [main] DEBUG org.seckill.dao.SeckillDao.queryById - ==>  Preparing: SELECT seckill_id, name, number, start_time, end_time, create_time from seckill where seckill_id = ?
            16:07:40.307 [main] DEBUG org.seckill.dao.SeckillDao.queryById - ==> Parameters: 1002(Long)
            16:07:40.342 [main] DEBUG org.seckill.dao.SeckillDao.queryById - <==      Total: 1
            16:07:40.350 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@72ade7e3]
            16:07:40.352 [main] WARN  o.seckill.service.SeckillServiceTest - exposer:Exposer{exposed=false, md5=null, seckillId=1002, now=1567843660352, start=1503360000000, end=1503396000000}
*/


}