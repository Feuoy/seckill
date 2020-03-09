package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;


public interface SeckillDao {


    /**
     *查询
     * @param seckillID
     * @return
     */
    Seckill queryById(long seckillID);



    /**
     * 根据偏移量查询列表
     * @param offset
     * @param limit
     * @return
     *
     * java没有保存形参的记录，所以offset与limit会被作为arg0,arg1传递，导致出错，用mybatis自带的@Param注解进行转义
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);


}
