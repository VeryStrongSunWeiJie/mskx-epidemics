package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.Util.Result;
import com.swj.entity.SysLog;
import com.swj.service.SysLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (SysLog)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:01
 */
@RestController
@RequestMapping("sysLog")
public class SysLogController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysLogService sysLogService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param sysLog 查询实体
     * @return 所有数据
     */
    @GetMapping
    public Result selectAll(Page<SysLog> page, SysLog sysLog) {
        return Result.success().data("data",this.sysLogService.page(page, new QueryWrapper<>(sysLog)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysLogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysLog 实体对象
     * @return 新增结果
     */
    @com.swj.log.SysLog
    @PostMapping
    public R insert(@RequestBody SysLog sysLog) {
        return success(this.sysLogService.save(sysLog));
    }

    /**
     * 修改数据
     *
     * @param sysLog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysLog sysLog) {
        return success(this.sysLogService.updateById(sysLog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysLogService.removeByIds(idList));
    }



}