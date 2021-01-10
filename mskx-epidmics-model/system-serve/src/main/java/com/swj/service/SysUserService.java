package com.swj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swj.entity.SysUser;
import com.swj.vo.SysUserVo;

import java.util.List;

/**
 * 用户信息表(SysUser)表服务接口
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:03
 */
public interface SysUserService extends IService<SysUser> {

    List<SysUserVo> getSysUserByDeptId(Integer deptId);
}