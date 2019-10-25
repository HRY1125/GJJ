package com.zlk.gjj.registerAndAccount.employee.service.impl;

import com.zlk.gjj.registerAndAccount.employee.mapper.EmployeeMapper;
import com.zlk.gjj.registerAndAccount.employee.service.EmployeeService;
import com.zlk.gjj.registerAndAccount.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author makejava
 * @since 2019-10-22 11:24:32
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public Employee queryById(Integer employeeId) {
        return this.employeeMapper.queryById(employeeId);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Employee> queryAllByLimit(int offset, int limit) {
        return this.employeeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param employee 实例对象
     * @return 对象列表
     */
    @Override
    public List<Employee> queryAll(Employee employee) {
        return employeeMapper.queryAll(employee);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 是否成功
     */
    @Override
    public Employee insert(Employee employee) {
        employee.setEmployeeCardRegistStatus("未制卡");
        this.employeeMapper.insert(employee);
        return employee;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee update(Employee employee) {
        this.employeeMapper.update(employee);
        return this.queryById(employee.getEmployeeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer employeeId) {
        return this.employeeMapper.deleteById(employeeId) > 0;
    }

    @Override
    public Employee selectEmployeeByNameAndPapersNameAndPapersNum(Employee employee) {
        return employeeMapper.selectEmployeeByNameAndPapersNameAndPapersNum(employee);
    }

    @Override
    public Integer deleteEmployeeByUnitId(String unitId) {
        return employeeMapper.deleteEmployeeByUnitId(unitId);
    }
}