package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.entity.MlLack;
import com.swj.service.MlLackService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (MlLack)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:04:57
 */
@RestController
@RequestMapping("mlLack")
public class MlLackController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MlLackService mlLackService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param mlLack 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<MlLack> page, MlLack mlLack) {
        return success(this.mlLackService.page(page, new QueryWrapper<>(mlLack)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.mlLackService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param mlLack 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody MlLack mlLack) {
        return success(this.mlLackService.save(mlLack));
    }

    /**
     * 修改数据
     *
     * @param mlLack 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody MlLack mlLack) {
        return success(this.mlLackService.updateById(mlLack));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.mlLackService.removeByIds(idList));
    }
}