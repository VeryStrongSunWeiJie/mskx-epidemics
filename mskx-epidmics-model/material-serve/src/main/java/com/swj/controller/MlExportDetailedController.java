package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.entity.MlExportDetailed;
import com.swj.service.MlExportDetailedService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (MlExportDetailed)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:04:57
 */
@RestController
@RequestMapping("mlExportDetailed")
public class MlExportDetailedController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MlExportDetailedService mlExportDetailedService;

    /**
     * 分页查询所有数据
     *
     * @param page             分页对象
     * @param mlExportDetailed 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<MlExportDetailed> page, MlExportDetailed mlExportDetailed) {
        return success(this.mlExportDetailedService.page(page, new QueryWrapper<>(mlExportDetailed)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.mlExportDetailedService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param mlExportDetailed 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody MlExportDetailed mlExportDetailed) {
        return success(this.mlExportDetailedService.save(mlExportDetailed));
    }

    /**
     * 修改数据
     *
     * @param mlExportDetailed 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody MlExportDetailed mlExportDetailed) {
        return success(this.mlExportDetailedService.updateById(mlExportDetailed));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.mlExportDetailedService.removeByIds(idList));
    }
}