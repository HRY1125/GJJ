package com.zlk.gjj.registerAndAccount.remittance.service.impl;

import com.zlk.gjj.registerAndAccount.entity.Remittance;
import com.zlk.gjj.registerAndAccount.remittance.mapper.RemittanceMapper;
import com.zlk.gjj.registerAndAccount.remittance.service.RemittanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Remittance)表服务实现类
 *
 * @author makejava
 * @since 2019-10-22 15:08:49
 */
@Service("remittanceService")
public class RemittanceServiceImpl implements RemittanceService {
    @Resource
    private RemittanceMapper remittanceMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param remittanceId 主键
     * @return 实例对象
     */
    @Override
    public Remittance queryById(Integer remittanceId) {
        return this.remittanceMapper.queryById(remittanceId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Remittance> queryAllByLimit(int offset, int limit) {
        return this.remittanceMapper.queryAllByLimit(offset, limit);
    }

    /**
     *  根据
     *
     * @param remittance
     * @return 对象列表
     */
    @Override
    public List<Remittance> queryAllByRemittance(Remittance remittance) {
        return remittanceMapper.queryAll(remittance);
    }

    /**
     * 新增数据
     *
     * @param remittance 实例对象
     * @return 实例对象
     */
    @Override
    public Remittance insert(Remittance remittance) {
        this.remittanceMapper.insert(remittance);
        return remittance;
    }

    /**
     * 修改数据
     *
     * @param remittance 实例对象
     * @return 实例对象
     */
    @Override
    public Remittance update(Remittance remittance) {
        this.remittanceMapper.update(remittance);
        return this.queryById(remittance.getRemittanceId());
    }

    /**
     * 通过主键删除数据
     *
     * @param remittanceId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer remittanceId) {
        return this.remittanceMapper.deleteById(remittanceId) > 0;
    }
}