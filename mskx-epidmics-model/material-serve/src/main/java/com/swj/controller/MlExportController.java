package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.entity.MlExport;
import com.swj.service.MlExportService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (MlExport)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:04:56
 */
@RestController
@RequestMapping("mlExport")
public class MlExportController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MlExportService mlExportService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param mlExport 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<MlExport> page, MlExport mlExport) {
        return success(this.mlExportService.page(page, new QueryWrapper<>(mlExport)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.mlExportService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param mlExport 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody MlExport mlExport) {
        return success(this.mlExportService.save(mlExport));
    }

    /**
     * 修改数据
     *
     * @param mlExport 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody MlExport mlExport) {
        return success(this.mlExportService.updateById(mlExport));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.mlExportService.removeByIds(idList));
    }
}