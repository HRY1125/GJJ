package com.zlk.gjj.registerAndAccount.remittance.controller;

import com.zlk.gjj.registerAndAccount.entity.Remittance;
import com.zlk.gjj.registerAndAccount.remittance.service.RemittanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}