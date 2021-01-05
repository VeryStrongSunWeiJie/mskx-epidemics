package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.Util.Result;
import com.swj.entity.SysMenu;
import com.swj.log.SysLog;
import com.swj.service.SysMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

/**
 * (SysMenu)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:01
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysMenu 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysMenu> page, SysMenu sysMenu) {
        return success(this.sysMenuService.page(page, new QueryWrapper<>(sysMenu)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysMenuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysMenu sysMenu) {
        return success(this.sysMenuService.save(sysMenu));
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysMenu sysMenu) {
        return success(this.sysMenuService.updateById(sysMenu));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysMenuService.removeByIds(idList));
    }

    /**
     * 获取三级菜单
     *
     * @param request 获取用户身份
     * @return
     */
    @SysLog
    @ApiOperation("获取三级菜单")
    @GetMapping("/getMenu")
    public Result getMenu(/*@RequestParam("roleID") Integer roleID*/
        HttpServletRequest request) {
        //根据身份查询三级菜单
        HttpSession session = request.getSession();
        Integer roleID=Integer.parseInt(session.getAttribute("role_id").toString());
        //获取当前用户身份
        List<SysMenu> list = this.sysMenuService.getThreeLevelMenu(roleID);
        return Result.success().data("list", list);
    }
}