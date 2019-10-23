package com.zlk.gjj.registerAndAccount.remittance.mapper;

import com.zlk.gjj.registerAndAccount.entity.Remittance;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wangzheng
 * @version 1.0
 * @date 2019/10/22 15:15
 */
public interface RemittanceMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param remittanceId 主键
     * @return 实例对象
     */
    Remittance queryById(Integer remittanceId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Remittance> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param remittance 实例对象
     * @return 对象列表
     */
    List<Remittance> queryAll(Remittance remittance);

    /**
     * 新增数据
     *
     * @param remittance 实例对象
     * @return 影响行数
     */
    int insert(Remittance remittance);

    /**
     * 修改数据
     *
     * @param remittance 实例对象
     * @return 影响行数
     */
    int update(Remittance remittance);

    /**
     * 通过主键删除数据
     *
     * @param remittanceId 主键
     * @return 影响行数
     */
    int deleteById(Integer remittanceId);

}
