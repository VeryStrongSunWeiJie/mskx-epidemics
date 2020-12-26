package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.entity.MlType;
import com.swj.service.MlTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (MlType)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:05:00
 */
@RestController
@RequestMapping("mlType")
public class MlTypeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MlTypeService mlTypeService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param mlType 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<MlType> page, MlType mlType) {
        return success(this.mlTypeService.page(page, new QueryWrapper<>(mlType)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.mlTypeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param mlType 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody MlType mlType) {
        return success(this.mlTypeService.save(mlType));
    }

    /**
     * 修改数据
     *
     * @param mlType 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody MlType mlType) {
        return success(this.mlTypeService.updateById(mlType));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.mlTypeService.removeByIds(idList));
    }
}