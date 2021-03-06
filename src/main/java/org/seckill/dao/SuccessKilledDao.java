package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

import java.util.Date;


//import org.seckill.model.SeckillInsertModel;
//
//import java.util.List;

public interface SuccessKilledDao {

    /**
     * 插入购买明细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @param createTime
     * @return 插入的结果行数
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId,
                            @Param("userPhone") long userPhone,
                            @Param("createTime") Date createTime);



//    int batchInsert(@Param("list") List<SeckillInsertModel> list);



    /**
     * 根据ID查询对象并携带秒杀对象
     * @param seckillId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIDWithSeckill(@Param("seckillId") long seckillId,
                                       @Param("userPhone") long userPhone);
}
