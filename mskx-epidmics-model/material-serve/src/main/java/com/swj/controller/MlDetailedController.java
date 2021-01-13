package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.Util.MybatisPlusConfig;
import com.swj.Util.Result;
import com.swj.entity.MlDetailed;
import com.swj.entity.SysDept;
import com.swj.service.MlDetailedService;
import com.swj.vo.CityVo;
import com.swj.vo.PageDetailedVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (MlDetailed)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:04:55
 */
@RestController
@RequestMapping("detailed")
public class MlDetailedController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MlDetailedService mlDetailedService;

    /**
     * 分页查询所有数据
     *
     * @param
     * @param mlDetailed 查询实体
     * @return 所有数据
     */
    @GetMapping
    public Result<?> selectAll(MlDetailed mlDetailed) {
        Page<MlDetailed> page = new Page<>(1, 5);
        Page<MlDetailed> page1 = this.mlDetailedService.page(page, new QueryWrapper<>(mlDetailed));
        List<MlDetailed> records = page1.getRecords();
        return Result.success().data("data", records);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.mlDetailedService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param mlDetailed 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody MlDetailed mlDetailed) {
        return success(this.mlDetailedService.save(mlDetailed));
    }

    /**
     * 修改数据
     *
     * @param mlDetailed 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody MlDetailed mlDetailed) {
        return success(this.mlDetailedService.updateById(mlDetailed));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.mlDetailedService.removeByIds(idList));
    }


    /**
     * 测试分页是否可用
     */
    @GetMapping("/getDetailedPage/{pageIndex}/{pageSize}")
    public Result<?> pageDetailed(@PathVariable Integer pageIndex, @PathVariable Integer pageSize) {
        MlDetailed mlDetailed = new MlDetailed();
       // mlDetailed.setMlDid(1);
        Page<MlDetailed> page = new Page<MlDetailed>(pageIndex, pageSize);
        List<MlDetailed> records = this.mlDetailedService.page(page, new QueryWrapper<>(mlDetailed)).getRecords();
        return Result.success().data("records", records);
    }

    /**
     * 正式版
     * @param pageDetailedVo    参数
     * @return
     */
    @GetMapping("/getDetailedPages")
    public Result<?> pageDetailed(@RequestBody PageDetailedVo pageDetailedVo) {
        MlDetailed mlDetailed = new MlDetailed();
        mlDetailed.setMlDname(pageDetailedVo.getMlDetailed().getMlDname());
        Page<MlDetailed> page = new Page<MlDetailed>(pageDetailedVo.getPageIndex(), pageDetailedVo.getPageSize());
        List<MlDetailed> records = this.mlDetailedService.page(page, new QueryWrapper<>(mlDetailed)).getRecords();
        return Result.success().data("records", records);
    }


    /**
     * 查出知道物资数量
     */
    @GetMapping("/getDetailedByName")
    public Result<?> getDetailedByName(@RequestParam("DName") String DName){
        QueryWrapper<MlDetailed> wrapper=new QueryWrapper<>();
        wrapper.like("ml_dname",DName);
        int sum = this.mlDetailedService.list(wrapper).stream().mapToInt(MlDetailed::getMlQuality).sum();
        return Result.success().data("sum",sum);
    }

    /**
     * 获取那些地方贡献了物资
     */
    @GetMapping("/getCity")
    public Result<?> getCity(){
        List<MlDetailed> list = this.mlDetailedService.list();
        List<MlDetailed> collect = list.stream().distinct().collect(Collectors.toList());
        List<CityVo> city = collect.stream().map((item) -> {
            CityVo mlDetailed = new CityVo();
            mlDetailed.setCity(item.getMlCity());
            return mlDetailed;
        }).collect(Collectors.toList());
        return Result.success().data("data",city);
    }
}