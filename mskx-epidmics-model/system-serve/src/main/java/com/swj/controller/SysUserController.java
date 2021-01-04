package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.Util.Result;
import com.swj.entity.SysUser;
import com.swj.entity.SysUserRole;
import com.swj.service.SysUserRoleService;
import com.swj.service.SysUserService;
import com.swj.vo.SysUserVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

/**
 * 用户信息表(SysUser)表控制层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:03
 */
@RestController
@RequestMapping("user")
public class SysUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysUser 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysUser> page, SysUser sysUser) {
        return success(this.sysUserService.page(page, new QueryWrapper<>(sysUser)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.save(sysUser));
    }

    /**
     * 修改数据
     *
     * @param sysUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.updateById(sysUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysUserService.removeByIds(idList));
    }


    @GetMapping("/info")
    public Result getInfo(){
        return null;
    }

    /**
     * 模拟登录接口
     * @return
     */
    @PostMapping("/login")
    public Result getLogin(@RequestParam("username")String username
                            , @RequestParam("password")String password
                            , HttpServletRequest request){
        HttpSession session = request.getSession();
        QueryWrapper<SysUser> wrapper=new QueryWrapper<>();
        wrapper.eq("user_name",username);
        SysUser one = this.sysUserService.getOne(wrapper);
        if (one!=null&&password.equals(one.getPassword())){
            //登录成功获取当前登录用户的身份编号
            QueryWrapper<SysUserRole> wrapper1=new QueryWrapper<>();
            wrapper1.eq("user_id",one.getUserId());
            SysUserRole one1 = this.sysUserRoleService.getOne(wrapper1);
            //存储用户身份id
            session.setAttribute("role_id",one1.getRoleId());
            //登录成功
            return Result.success().data("success",one);
        }
        //登录失败
        return Result.error().message("失败");
    }


    /**
     * 实现用户退出
     * @return
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        session.removeAttribute("role_id");
        return Result.success();
    }


}