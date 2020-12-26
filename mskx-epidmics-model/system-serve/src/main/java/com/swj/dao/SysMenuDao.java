package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysMenu)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:01
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenu> {

}