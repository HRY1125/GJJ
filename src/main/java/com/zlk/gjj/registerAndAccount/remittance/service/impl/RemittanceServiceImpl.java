package com.zlk.gjj.registerAndAccount.remittance.service.impl;

import com.zlk.gjj.registerAndAccount.employee.service.EmployeeService;
import com.zlk.gjj.registerAndAccount.entity.Employee;
import com.zlk.gjj.registerAndAccount.entity.Remittance;
import com.zlk.gjj.registerAndAccount.entity.vo.Emp_Rem;
import com.zlk.gjj.registerAndAccount.remittance.mapper.RemittanceMapper;
import com.zlk.gjj.registerAndAccount.remittance.service.RemittanceService;
import com.zlk.gjj.registerAndAccount.secondAssist.mapper.SecondAssistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (Remittance)表服务实现类
 *
 * @author makejava
 * @since 2019-10-22 15:08:49
 */
@Service("remittanceService")
public class RemittanceServiceImpl implements RemittanceService {
    @Autowired
    private RemittanceMapper remittanceMapper;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SecondAssistMapper secondAssistMapper;

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
        Employee employee=employeeService.insert(new Employee());
        remittance.setEmployeeId(employee.getEmployeeId());
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

    @Override
    public List<Emp_Rem> selRemAndEmpAndSAAll(String UnitRegisterId,int offset, int limit) {
        List<Emp_Rem> empRemList=new ArrayList<>();
        List<Remittance>  remittanceList=remittanceMapper.queryAllByRemittanceAndLimit(UnitRegisterId, offset,  limit);
        for(Remittance remittance:remittanceList){
            Employee employee=employeeService.queryById(remittance.getEmployeeId());
            Emp_Rem empRem=new Emp_Rem();
            empRem.setEmployeeId(employee.getEmployeeId());
            empRem.setEmployeeName(employee.getEmployeeName());
            empRem.setEmployeePapersName(employee.getEmployeePapersName());
            empRem.setEmployeePapersNum(employee.getEmployeePapersNum());
            empRem.setEmployeeNationnality(employee.getEmployeeNationnality());
            empRem.setEmployeeDeposite(remittance.getEmployeeDeposite());
            empRem.setDepositBase(remittance.getDepositBase());
            empRem.setDepositeTotal(remittance.getDepositeTotal());
            empRem.setUnitRegisterId(remittance.getUnitRegisterId());
            empRem.setUnitDeposite(remittance.getUnitDeposite());
            empRem.setSaId(remittance.getSaId());
            empRem.setRemittanceId(remittance.getRemittanceId());
            empRemList.add(empRem);
        }
        return empRemList;
    }

    @Override
    public String updateEmpAndRem(Emp_Rem empRem) {
        Employee employee = new Employee();
        Remittance remittance = new Remittance();
        employee.setEmployeeId(empRem.getEmployeeId());
        employee.setEmployeePapersNum(empRem.getEmployeePapersNum());
        employee.setEmployeeName(empRem.getEmployeeName());
        employee.setEmployeePapersName(empRem.getEmployeePapersName());
        employee.setEmployeeNationnality(empRem.getEmployeeNationnality());
        remittance.setSaId(empRem.getSaId());
        remittance.setRemittanceId(empRem.getRemittanceId());
        remittance.setEmployeeId(empRem.getEmployeeId());
        remittance.setDepositBase(empRem.getDepositBase());
        remittance.setDepositeTotal(empRem.getEmployeeDeposite()+empRem.getUnitDeposite());
        remittance.setEmployeeDeposite(empRem.getEmployeeDeposite());
        remittance.setUnitDeposite(empRem.getUnitDeposite());
        remittance.setUnitRegisterId(empRem.getUnitRegisterId());
        int i1= remittanceMapper.update(remittance);
        Employee emp1=employeeService.update(employee);
        if (i1>0&emp1!=null){
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String deleRemAndEmp(Emp_Rem empRem) {
        int RemittanceId=empRem.getRemittanceId();
        int EmployeeId = empRem.getEmployeeId();
        boolean de =employeeService.deleteById(EmployeeId);
        int dr = remittanceMapper.deleteById(RemittanceId);
        if (de=true&dr>0){
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public List<Employee> selectRemAndEmpByUnitRegisterId(String unitRegisterId,int offset, int limit) {
        List<Employee> employees= new ArrayList<>();
        Remittance remittance = new Remittance();
        remittance.setUnitRegisterId(unitRegisterId);
        List<Remittance> remittanceList = remittanceMapper.queryAllByRemittanceAndLimit(unitRegisterId,offset,limit);
        for (Remittance rem:remittanceList) {
            Employee employee = employeeService.queryById(rem.getEmployeeId());
            employees.add(employee);
        }
        return employees;
    }

}