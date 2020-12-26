package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysRole)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:02
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRole> {

}