package com.swj.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.Util.Result;
import com.swj.entity.MlLacks;
import com.swj.service.MlLacksService;
import com.swj.vo.MlLacksVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (MlLacks)表控制层
 *
 * @author sunweijie
 * @since 2021-01-13 15:10:36
 */
@RestController
@RequestMapping("mlLacks")
public class MlLacksController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MlLacksService mlLacksService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param mlLacks 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<MlLacks> page, MlLacks mlLacks) {
        return success(this.mlLacksService.page(page, new QueryWrapper<>(mlLacks)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.mlLacksService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param mlLacks 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody MlLacks mlLacks) {
        return success(this.mlLacksService.save(mlLacks));
    }

    /**
     * 修改数据
     *
     * @param mlLacks 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody MlLacks mlLacks) {
        return success(this.mlLacksService.updateById(mlLacks));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.mlLacksService.removeByIds(idList));
    }


    /**
     * 查询急缺医院急缺物资
     */
    @PostMapping("/getMlLacksAlls")
    public Result<?> getMlLacksAlls(@RequestBody Map<String,Object> map){
        System.out.println("map = " + map);
        //获取所有医院信息
        List<MlLacksVo> lacks=this.mlLacksService.getMlLacksAll(map);
        return  Result.success().data("lacks",lacks);
    }

    @PostMapping("/getMlLacksAll")
    public Result<?> getMlLacksAll(@RequestBody JSONObject map){
        System.out.println("jsonObject = " + map.toJSONString());
        System.out.println("map = " + map.getString("pageIndex"));
        //获取所有医院信息
        Map<String, Object> map1=new HashMap<>();
        map1.put("pageIndex",map.getString("pageIndex"));
        map1.put("pageSize",map.getString("pageSize"));
        map1.put("mlLState",map.getString("mlLState"));
        List<MlLacksVo> lacks=this.mlLacksService.getMlLacksAll(map1);
        return  Result.success().data("lacks",lacks);
    }
}