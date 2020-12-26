package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.entity.PwAttendance;
import com.swj.service.PwAttendanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (PwAttendance)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:02:36
 */
@RestController
@RequestMapping("pwAttendance")
public class PwAttendanceController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PwAttendanceService pwAttendanceService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param pwAttendance 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PwAttendance> page, PwAttendance pwAttendance) {
        return success(this.pwAttendanceService.page(page, new QueryWrapper<>(pwAttendance)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.pwAttendanceService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param pwAttendance 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PwAttendance pwAttendance) {
        return success(this.pwAttendanceService.save(pwAttendance));
    }

    /**
     * 修改数据
     *
     * @param pwAttendance 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PwAttendance pwAttendance) {
        return success(this.pwAttendanceService.updateById(pwAttendance));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.pwAttendanceService.removeByIds(idList));
    }
}