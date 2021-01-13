package com.swj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.Util.PageUtils;
import com.swj.Util.Query;
import com.swj.Util.Result;
import com.swj.dao.SysRoleDao;
import com.swj.dao.SysUserDao;
import com.swj.entity.SysRole;
import com.swj.entity.SysUser;
import com.swj.service.SysRoleService;
import com.swj.service.SysUserService;
import com.swj.vo.SysUserVo;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private SysUserDao sysUserDao;

    @Resource
    private SysRoleDao sysRoleDao;

    //    @Override
//    public List<SysUserVo> getSysUserByDeptId(Integer DeptId) {
//        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
//        log.info("获取到的部门编号为：" + DeptId);
//        wrapper.eq("dept_id", DeptId);
//        //SysUser one = this.sysUserService.getOne(wrapper);
//        //根据部门信息获取所有员工信息
//        List<SysUser> list = this.sysUserDao.selectList(wrapper);
//        List<SysUserVo> UserVo = list.stream().map(sysUser -> {
//            SysUserVo sysUserVo = new SysUserVo();
//            sysUserVo.setId(sysUser.getUserId());
//            sysUserVo.setNickName(sysUser.getNickName());
//            sysUserVo.setAvatar(sysUser.getAvatar());
//            sysUserVo.setEmail(sysUser.getEmail());
//            sysUserVo.setPhonenumber(sysUser.getPhonenumber());
//            sysUserVo.setCreateTime(sysUser.getCreateTime().toString());
//            //判断用户身份
//            String sex = sysUser.getSex().equals("0") ? "男" : "女";
//            sysUserVo.setSex(sex);
//            //根据用户身份查询用户数据
//            QueryWrapper<SysRole> wrapper1 = new QueryWrapper<>();
//            wrapper1.eq("role_id", sysUser.getRoleId());
//            SysRole one = this.sysRoleDao.selectOne(wrapper1);
//            sysUserVo.setRoleName(one.getRoleName());
//            return sysUserVo;
//        }).collect(Collectors.toList());
//        if (list != null && UserVo != null) {
//            return UserVo;
//        }
//        return null;
//    }
//
//    /**
//     * 使用Mybatis-plus分页
//     *
//     * @param map
//     * @return
//     */
//    @Override
//    public List<SysUserVo> getSysUserByMap(Map<String, Object> map) {
//        //获取到参数
//        Integer deptId = Integer.parseInt(map.get("DeptId").toString());
//        //查询部门编号为deptId的
//        Page<SysUser> page = new Page<SysUser>(Long.parseLong(map.get("page").toString())
//                , Long.parseLong(map.get("limit").toString()));
//        List<SysUser> list = this.sysUserDao.selectPage(page,
//                new QueryWrapper<SysUser>().eq("dept_id", deptId)).getRecords();
//        List<SysUserVo> role_id = list.stream().map(sysUser -> {
//            SysUserVo sysUserVo = new SysUserVo();
//            sysUserVo.setId(sysUser.getUserId());
//            sysUserVo.setNickName(sysUser.getNickName());
//            sysUserVo.setAvatar(sysUser.getAvatar());
//            sysUserVo.setEmail(sysUser.getEmail());
//            sysUserVo.setPhonenumber(sysUser.getPhonenumber());
//            sysUserVo.setCreateTime(sysUser.getCreateTime().toString());
//            //判断用户身份
//            String sex = sysUser.getSex().equals("0") ? "男" : "女";
//            sysUserVo.setSex(sex);
//            //根据用户身份查询用户数据
//            QueryWrapper<SysRole> wrapper1 = new QueryWrapper<>();
//            wrapper1.eq("role_id", sysUser.getRoleId());
//            SysRole one = this.sysRoleDao.selectOne(wrapper1);
//            sysUserVo.setRoleName(one.getRoleName());
//            return sysUserVo;
//        }).collect(Collectors.toList());
//        return role_id;
//    }

    @Override
    public PageUtils getSysUserByMaps(Map<String, Object> map) {
        //获取到参数
        Integer deptId = Integer.parseInt(map.get("DeptId").toString());
        //查询部门编号为deptId的
        Page<SysUser> page = new Page<SysUser>(Long.parseLong(map.get("page").toString())
                , Long.parseLong(map.get("limit").toString()));
        List<SysUser> list = new ArrayList<>();
        if (deptId == null) {
            list = this.sysUserDao.selectPage(page,
                    null
            ).getRecords();
        } else {
            list = this.sysUserDao.selectPage(page,
                    new QueryWrapper<SysUser>().eq("dept_id", deptId)
            ).getRecords();
        }
        List<SysUserVo> role_id = list.stream().map(sysUser -> {
            SysUserVo sysUserVo = new SysUserVo();
            sysUserVo.setId(sysUser.getUserId());
            sysUserVo.setNickName(sysUser.getNickName());
            sysUserVo.setAvatar(sysUser.getAvatar());
            sysUserVo.setEmail(sysUser.getEmail());
            sysUserVo.setPhonenumber(sysUser.getPhonenumber());
            sysUserVo.setCreateTime(sysUser.getCreateTime().toString());
            //判断用户身份
            String sex = sysUser.getSex().equals("0") ? "男" : "女";
            sysUserVo.setSex(sex);
            //根据用户身份查询用户数据
            QueryWrapper<SysRole> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("role_id", sysUser.getRoleId());
            SysRole one = this.sysRoleDao.selectOne(wrapper1);
            sysUserVo.setRoleName(one.getRoleName());
            return sysUserVo;
        }).collect(Collectors.toList());
        int size = Integer.parseInt(String.valueOf(page.getSize()));
        int current = Integer.parseInt(String.valueOf(page.getCurrent()));

        return new PageUtils(role_id, this.sysUserDao.selectCount(new QueryWrapper<SysUser>().eq("dept_id", deptId)), size, current);
    }



}