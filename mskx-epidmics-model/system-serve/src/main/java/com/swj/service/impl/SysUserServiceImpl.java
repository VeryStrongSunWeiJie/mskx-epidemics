package com.swj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.Util.Result;
import com.swj.dao.SysUserDao;
import com.swj.entity.SysRole;
import com.swj.entity.SysUser;
import com.swj.service.SysRoleService;
import com.swj.service.SysUserService;
import com.swj.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:03
 */
@Slf4j
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysRoleService sysRoleService;

    @Override
    public List<SysUserVo> getSysUserByDeptId(Integer DeptId) {
        QueryWrapper<SysUser> wrapper=new QueryWrapper<>();
        log.info("获取到的部门编号为："+DeptId);
        wrapper.eq("dept_id",DeptId);
        //SysUser one = this.sysUserService.getOne(wrapper);
        //根据部门信息获取所有员工信息
        List<SysUser> list = this.sysUserService.list(wrapper);
        List<SysUserVo> UserVo = list.stream().map(sysUser -> {
            SysUserVo sysUserVo = new SysUserVo();
            sysUserVo.setId(sysUser.getUserId());
            sysUserVo.setNickName(sysUser.getNickName());
            sysUserVo.setAvatar(sysUser.getAvatar());
            sysUserVo.setEmail(sysUser.getEmail());
            sysUserVo.setPhonenumber(sysUser.getPhonenumber());
            sysUserVo.setCreateTime(sysUser.getCreateTime().toString());
            //判断用户身份
            String sex=sysUser.getSex().equals("0")?"男":"女";
            sysUserVo.setSex(sex);
            //根据用户身份查询用户数据
            QueryWrapper<SysRole> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("role_id", sysUser.getRoleId());
            SysRole one = this.sysRoleService.getOne(wrapper1);
            sysUserVo.setRoleName(one.getRoleName());
            return sysUserVo;
        }).collect(Collectors.toList());
        if (list!=null&&UserVo!=null){
            return UserVo;
        }
        return null;
    }
}