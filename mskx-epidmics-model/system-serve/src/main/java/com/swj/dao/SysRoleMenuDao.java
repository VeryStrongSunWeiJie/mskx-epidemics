package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysRoleMenu)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:02
 */
@Mapper
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenu> {

}