package com.zlk.gjj.registerAndAccount.remittance.controller;

import com.zlk.gjj.registerAndAccount.entity.Employee;
import com.zlk.gjj.registerAndAccount.entity.Remittance;
import com.zlk.gjj.registerAndAccount.entity.vo.Emp_Rem;
import com.zlk.gjj.registerAndAccount.remittance.service.RemittanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Remittance)表控制层
 *
 * @author makejava
 * @since 2019-10-22 15:08:49
 */
@RestController
@RequestMapping("remittance")
public class RemittanceController {
    /**
     * 服务对象
     */
    @Autowired
    private RemittanceService remittanceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectRemittanceOne")
    public Remittance selectOne(Integer id) {
        return this.remittanceService.queryById(id);
    }

    /**
     * 查询全部
     */
    @RequestMapping("selectRemittanceAll")
    public List<Remittance> selectAll(Remittance remittance){
        return remittanceService.queryAllByRemittance(remittance);
    }

    /**
     * 新增数据
     */
    @RequestMapping("insRemittance")
    public Remittance insertRemittance(Remittance remittance){
        return remittanceService.insert(remittance);
    }
    /**
     * 根据id删除数据
     */
    @RequestMapping("delectRemittanceById")
    public boolean delectRemittanceById(Integer id){
        return remittanceService.deleteById(id);
    }

    /**
     * 修改数据根据对象
     * @param remittance
     * @return
     */
    @RequestMapping("updateByRemittance")
    public Remittance updateByRemittance(Remittance remittance){
        return remittanceService.update(remittance);
    }

    @RequestMapping("selRemAndEmpAndSAAll")
    public List<Emp_Rem> selRemAndEmpAndSAAll(int offset, int limit){
        return remittanceService.selRemAndEmpAndSAAll(offset, limit);
    }

    @RequestMapping("updateEmpAndRem")
    public String updateEmpAndRem(Emp_Rem empRem){
        return remittanceService.updateEmpAndRem(empRem);
    }

    @RequestMapping("delEmpAndRem")
    public String delEmpAndRem(Emp_Rem empRem){
        empRem.setEmployeeId(10);
        empRem.setRemittanceId(5);
        return remittanceService.deleRemAndEmp(empRem);
    }

    @RequestMapping("select")
    public Map selRemAndEmpAndSAAll1(Integer page,Integer limit){
        int offset=(page-1)*limit;
        List<Emp_Rem> emp_rems = remittanceService.selRemAndEmpAndSAAll(offset, limit);
        int count = emp_rems.size();
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",emp_rems);
        return map;
    }


    @RequestMapping("add")
    @ResponseBody
    public Map insertRemittance1(Remittance remittance){
        remittanceService.insert(remittance);
        Map map = new HashMap();
        return map;
    }

    @RequestMapping("delete")
    public Map delEmpAndRem1(@RequestBody Emp_Rem empRem){
        remittanceService.deleRemAndEmp(empRem);
        Map map = new HashMap();
        return map;
    }

    @RequestMapping("update")
    public Map updateEmpAndRem1(@RequestBody Emp_Rem empRem){
        remittanceService.updateEmpAndRem(empRem);
        Map map = new HashMap();
        return map;
    }
    /**
     * 2.13的查询
     */
    @RequestMapping("selRemAndEmpByUnitRegisterId")
    public Map selRemAndEmpByUnitRegisterId(Integer page,Integer limit,String unitRegisterId) {
        int offset=(page-1)*limit;
        List<Employee> employees = remittanceService.selectRemAndEmpByUnitRegisterId(unitRegisterId,offset,limit);
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", employees.size());
        map.put("data", employees);
        return map;
    }

}