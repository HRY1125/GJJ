package com.zlk.gjj.registerAndAccount.employee.contorller;

import com.zlk.gjj.registerAndAccount.employee.service.EmployeeService;
import com.zlk.gjj.registerAndAccount.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2019-10-22 11:24:32
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectEmployeeOne")
    @ResponseBody
    public Employee selectOne(Integer id) {
        return this.employeeService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param employee 对象
     * @return 是否成功
     */
    @RequestMapping("insEmployee")
    @ResponseBody
    public boolean insertEmployee(Employee employee){
        return employeeService.insert(employee);
    }

    /**
     * 根据对象查询
     */
    @RequestMapping("selEmployeeAll")
    @ResponseBody
    public List<Employee> selEmployeebyEmployee(Employee employee){
        return employeeService.queryAll(employee);
    }
    /**
     * 根据id删除数据
     */
    @RequestMapping("delEmployeeById")
    @ResponseBody
    public boolean deleteEmployeeById(Integer id){
        return employeeService.deleteById(id);
    }
    /**
     * 通过对象修改数据
     */
    @RequestMapping("updateEmployee")
    @ResponseBody
    public Employee updateEmployee(Employee employee){
        return employeeService.update(employee);
    }

}