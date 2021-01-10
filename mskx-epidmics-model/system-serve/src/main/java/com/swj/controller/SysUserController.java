package com.swj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swj.Util.Result;
import com.swj.entity.SysRole;
import com.swj.entity.SysUser;
import com.swj.entity.SysUserRole;
import com.swj.log.SysLog;
import com.swj.service.SysRoleService;
import com.swj.service.SysUserRoleService;
import com.swj.service.SysUserService;
import com.swj.vo.SysUserVo;
import com.swj.vo.UserVo;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private SysRoleService sysRoleService;

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


    @GetMapping("/infos")
    public Result getInfos(HttpServletRequest request) {
        //TODO 暂时未完成
        HttpSession session = request.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("user");
        //通过用户编号，查看用户身份
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", sysUser.getUserId());
        SysUserRole one = this.sysUserRoleService.getOne(wrapper);
        //根据rold_id查询身份
        SysRole byId = this.sysRoleService.getById(one.getRoleId());
        return Result.success()
                .data("roles", "[" + byId.getRoleKey() + "]")
                .data("name", sysUser.getNickName())
                .data("avatar", sysUser.getAvatar());
        //return Result.success().data("roles", "[admin]")
        // .data("name", "admin")
        // .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }


    @GetMapping("/info")
    public Result getInfo(HttpServletRequest request) {
        //TODO 暂时未完成
        HttpSession session = request.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("user");
        //通过用户编号，查看用户身份
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", sysUser.getUserId());
        //根据user_id获取用户信息并且重新组装信息返回
        QueryWrapper<SysUser> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("user_id", sysUser.getUserId());
        SysUser user = this.sysUserService.getOne(wrapper1);
        SysUserRole one = this.sysUserRoleService.getOne(wrapper);
        //根据rold_id查询身份
        SysRole byId = this.sysRoleService.getById(one.getRoleId());
        return Result.success().data("data", user).data("role", byId.getRoleName());
    }

    /**
     * 模拟登录接口
     *
     * @return
     */
    @SysLog
    @PostMapping("/logins")
    public Result getLogin(@RequestParam("username") String username
            , @RequestParam("password") String password
            , HttpServletRequest request) {
        HttpSession session = request.getSession();
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        SysUser one = this.sysUserService.getOne(wrapper);
        if (one != null && password.equals(one.getPassword())) {
            //登录成功获取当前登录用户的身份编号
            QueryWrapper<SysUserRole> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("user_id", one.getUserId());
            SysUserRole one1 = this.sysUserRoleService.getOne(wrapper1);
            //存储用户身份id
            if (one1 != null) {
                //存储用户信息，用户info返回
                session.setAttribute("user", one);
                session.setAttribute("role_id", one1.getRoleId());
                //登录成功
                logger.info("登录成功" + Result.success().data("user", one).data("token", "admin-token"));
                return Result.success().data("user", one).data("token", "admin-token");
            } else {
                //登录失败
                return Result.error().message("对不起，该用户暂时未被授权");
            }
        }
        //登录失败
        return Result.error().message("登录失败");
    }


    /**
     * 实现用户退出
     *
     * @return
     */
    @SysLog
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        session.removeAttribute("role_id");
        return Result.success();
    }

    /**
     * 根据部门编号获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/findUserByDeptId")
    public Result findUserByDeptId(@RequestParam Integer id) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("dept_id", id);
        SysUser one = this.sysUserService.getOne(wrapper);
        return Result.success().data("data", one);
    }


    /**
     * 模拟登录接口
     *
     * @return
     */
    @SysLog
    @PostMapping("/login")
    public Result getLogins(@RequestBody UserVo sysUserVo, HttpServletRequest request) {
        System.out.println("sysUserVo.getPassword() = " + sysUserVo.getPassword());
        HttpSession session = request.getSession();
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", sysUserVo.getUsername());
        SysUser one = this.sysUserService.getOne(wrapper);
        if (one != null && sysUserVo.getPassword().equals(one.getPassword())) {
            //登录成功获取当前登录用户的身份编号
            QueryWrapper<SysUserRole> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("user_id", one.getUserId());
            SysUserRole one1 = this.sysUserRoleService.getOne(wrapper1);
            //存储用户身份id
            if (one1 != null) {
                //存储用户信息，用户info返回
                session.setAttribute("user", one);
                session.setAttribute("role_id", one1.getRoleId());
                //登录成功
                return Result.success().data("user", one).data("token", "admin-token");
            } else {
                //登录失败
                return Result.error().message("对不起，该用户暂时未被授权");
            }
        }
        //登录失败
        return Result.error().message("登录失败");
    }


    /**
     * 根据部门编号获取用户信息
     */
    @SysLog
    @GetMapping("/getUserByDeptId/{DeptId}")
    public Result getUserByDeptId(@PathVariable Integer DeptId){

        List<SysUserVo> user =this.sysUserService.getSysUserByDeptId(DeptId);

        return Result.success().message("数据返回成功").data("user",user);
    }

}