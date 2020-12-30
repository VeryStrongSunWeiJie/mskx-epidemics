package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.Util.Result;
import com.swj.entity.PwDept;
import com.swj.service.PwDeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (PwDept)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:02:36
 */
@RestController
@RequestMapping("pwDept")
public class PwDeptController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PwDeptService pwDeptService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param pwDept 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PwDept> page, PwDept pwDept) {
        return success(this.pwDeptService.page(page, new QueryWrapper<>(pwDept)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pwDeptService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pwDept 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PwDept pwDept) {
        return success(this.pwDeptService.save(pwDept));
    }

    /**
     * 修改数据
     *
     * @param pwDept 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PwDept pwDept) {
        return success(this.pwDeptService.updateById(pwDept));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pwDeptService.removeByIds(idList));
    }


    @GetMapping("/getMenu")
    public Result getMenu(){
        List<PwDept> list=this.pwDeptService.getMenus();
        return Result.success().data("data",list);
    }
}