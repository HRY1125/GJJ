package com.zlk.gjj.registerAndAccount.employee.service;

import com.zlk.gjj.registerAndAccount.entity.Employee;

import java.util.List;

/**
 * @author wangzheng
 * @version 1.0
 * @date 2019/10/22 11:18
 */
public interface EmployeeService {
    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    Employee queryById(Integer employeeId);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Employee> queryAllByLimit(int offset, int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param employee 实例对象
     * @return 对象列表
     */
    List<Employee> queryAll(Employee employee);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 是否成功
     */
    Employee insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer employeeId);


}
