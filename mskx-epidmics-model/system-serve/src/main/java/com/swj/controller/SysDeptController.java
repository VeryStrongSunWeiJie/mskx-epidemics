package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.Util.Result;
import com.swj.log.SysLog;
import com.swj.entity.SysDept;
import com.swj.service.SysDeptService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 部门表(SysDept)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:00
 */
@RestController
@RequestMapping("sysDept")
public class SysDeptController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysDeptService sysDeptService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @SysLog
    @GetMapping("/all/{current}/{size}")
    public Result selectAll(@PathVariable Integer current,
                       @PathVariable Integer size) {
        Page<SysDept> page = new Page(current, size);
        return Result.success().data("data",this.sysDeptService.page(page));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysDeptService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysDept 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysDept sysDept) {
        return success(this.sysDeptService.save(sysDept));
    }

    /**
     * 修改数据
     *
     * @param sysDept 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysDept sysDept) {
        return success(this.sysDeptService.updateById(sysDept));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysDeptService.removeByIds(idList));
    }

    @SysLog
    @ApiOperation(value = "获取部门三级菜单")
    @GetMapping("/deptMenu")
    public Result deptMenu() {
        List<SysDept> sysDepts = this.sysDeptService.getMenu();
        return Result.success().data("sysDepts", sysDepts);
    }

}