package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表(SysUser)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:03
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

}