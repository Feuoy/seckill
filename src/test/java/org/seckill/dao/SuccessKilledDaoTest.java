package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
/*
 * 配置spring与junit整合，junit启动加载springIOC容器
 * ctrl+shift+t创建
 * */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {


    @Autowired
    private SuccessKilledDao successKilledDao;


    /*
     * 第一次返回1，第二次返回0
     * */
    @Test
    public void insertSuccessKilled() throws Exception {
        /*
         * 循环单挑插入1000次
         * */
        long id = 1002L;
        long phone = 18700000000L;

/*        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        System.out.println("当前时间为: " + ft.format(dNow));*/
        Date time = new Date(System.currentTimeMillis() + + 8 * 60 * 60 * 1000);

        int insertCount = successKilledDao.insertSuccessKilled(id, phone, time);
        System.out.println("insertCount=" + insertCount);


//        long beginTime = System.currentTimeMillis();
//        for (int i = 0; i < 1; i++) {
//            id += i;
//            phone += i;
//            int insertCount = successKilledDao.insertSuccessKilled(id, phone);
//            System.out.println("insertCount:" + insertCount);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("begin:" + beginTime);
//        System.out.println("end：" + endTime);
//        System.out.println("diff:" + (endTime - beginTime));



      /*  System.out.println(new Date(1503909096825L));
        System.out.println(new Date(1503909139484L));
        long beginTime=System.currentTimeMillis();
        System.out.println("begin:"+beginTime);
        List<SeckillInsertModel> list=new ArrayList<SeckillInsertModel>();
        SeckillInsertModel seckillInsertModel;
        for(int i=0;i<1000;i++){
            seckillInsertModel=new SeckillInsertModel();
            long id=1000L+i;
            long phone = 18700000000L+i;
            seckillInsertModel.setSeckillId(id);
            seckillInsertModel.setUserPhone(phone);
            list.add(seckillInsertModel);
            // int insertCount=successKilledDao.insertSuccessKilled(id,phone);
            // System.out.println("insertCount:"+insertCount);
        }
        int insertCount=successKilledDao.batchInsert(list);
        System.out.println(insertCount);
        long endTime=System.currentTimeMillis();
        System.out.println("end："+endTime);
        System.out.println("diff:"+(endTime-beginTime));*/
    }
/*13:22:43.583 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Creating a new SqlSession
13:22:43.594 [main] DEBUG org.mybatis.spring.SqlSessionUtils - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2892d68] was not registered for synchronization because synchronization is not active
    九月 07, 2019 1:22:43 下午 com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource getPoolManager
    信息: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 3, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> false, checkoutTimeout -> 1000, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, dataSourceName -> 2son7xa52tmndiq84bfe|6293abcc, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.mysql.cj.jdbc.Driver, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, identityToken -> 2son7xa52tmndiq84bfe|6293abcc, idleConnectionTestPeriod -> 0, initialPoolSize -> 3, jdbcUrl -> jdbc:mysql://127.0.0.1:3306/seckill?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 10, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 50000, maxStatements -> 0, maxStatementsPerConnection -> 0, minPoolSize -> 10, numHelperThreads -> 3, numThreadsAwaitingCheckoutDefaultUser -> 0, preferredTestQuery -> null, properties -> {user=******, password=******}, propertyCycle -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 1, usesTraditionalReflectiveProxies -> false ]
            13:22:44.673 [main] DEBUG o.m.s.t.SpringManagedTransaction - JDBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@d737b89] will not be managed by Spring
13:22:44.701 [main] DEBUG o.s.d.S.insertSuccessKilled - ==>  Preparing: *//*主键冲突，报错*//* insert ignore into success_killes(seckill_id, user_phone) value (?, ?)
            13:22:44.778 [main] DEBUG o.s.d.S.insertSuccessKilled - ==> Parameters: 1001(Long), 18700000000(Long)
            13:22:44.782 [main] DEBUG o.s.d.S.insertSuccessKilled - <==    Updates: 0
            13:22:44.815 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2892d68]
    insertCount=0*/



    // 连接数: 修改最大连接，或连接关闭
    // 查询为null,creat_time没有赋值
    @Test
    public void queryByIDWithSeckill() throws Exception {
        long id = 1002L;
        long phone = 18700000000L;
        SuccessKilled successKilled = successKilledDao.queryByIDWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
/*
    13:22:44.822 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Creating a new SqlSession
13:22:44.823 [main] DEBUG org.mybatis.spring.SqlSessionUtils - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@72bc6553] was not registered for synchronization because synchronization is not active
13:22:44.826 [main] DEBUG o.m.s.t.SpringManagedTransaction - JDBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@4f32a3ad] will not be managed by Spring
13:22:44.826 [main] DEBUG o.s.d.S.queryByIDWithSeckill - ==>  Preparing: SELECT sk.seckill_id, sk.user_phone, sk.crate_time, sk.state, s.seckill_id "seckill.seckill_id", # s.name "seckill.seckill_id", s.name "seckill.seckill_name", s.number "seckill.number", s.start_time "seckill.start_time", s.end_time "seckill.end_time", s.create_time "seckill.create_time" from success_killes sk inner join seckill s on sk.seckill_id = s.seckill_id where sk.seckill_id = ? and sk.user_phone = ?
            13:22:44.826 [main] DEBUG o.s.d.S.queryByIDWithSeckill - ==> Parameters: 1001(Long), 18700000000(Long)
            13:22:44.856 [main] DEBUG o.s.d.S.queryByIDWithSeckill - <==      Total: 1
            13:22:44.863 [main] DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@72bc6553]
    SuccessKilled{seckillId=1001, userPhone=18700000000, state=-1, crateTime=Sat Sep 07 21:11:51 CST 2019}
    Seckill{seckillID=1001, name=null, number=20, startTime=Tue Aug 22 08:00:00 CST 2017, endTime=Tue Aug 22 18:00:00 CST 2017, createTime=Sat Sep 07 04:54:54 CST 2019}
*/



}