package com.zlk.gjj.registerAndAccount.remittance.service;

import com.zlk.gjj.registerAndAccount.entity.Employee;
import com.zlk.gjj.registerAndAccount.entity.Remittance;
import com.zlk.gjj.registerAndAccount.entity.vo.Emp_Rem;

import java.util.List;

/**
 * (Remittance)表服务接口
 *
 * @author makejava
 * @since 2019-10-22 15:08:49
 */
public interface RemittanceService {

    /**
     * 通过ID查询单条数据
     *
     * @param remittanceId 主键
     * @return 实例对象
     */
    Remittance queryById(Integer remittanceId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Remittance> queryAllByLimit(int offset, int limit);

    /**
     * 查询所有根据某一个字段
     *
     * @param remittance
     * @return 对象列表
     */
    List<Remittance> queryAllByRemittance(Remittance remittance);

    /**
     * 新增数据
     *
     * @param remittance 实例对象
     * @return 实例对象
     */
    Remittance insert(Remittance remittance);

    /**
     * 修改数据
     *
     * @param remittance 实例对象
     * @return 实例对象
     */
    Remittance update(Remittance remittance);

    /**
     * 通过主键删除数据
     *
     * @param remittanceId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer remittanceId);

    List<Emp_Rem> selRemAndEmpAndSAAll(int offset, int limit);

    String updateEmpAndRem(Emp_Rem empRem);

    String deleRemAndEmp(Emp_Rem empRem);

    List<Employee> selectRemAndEmpByUnitRegisterId(String UnitRegisterId,int offset, int limit);
}