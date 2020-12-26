package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysUserRole)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:04
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

}