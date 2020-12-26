package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门表(SysDept)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:00:59
 */
@Mapper
public interface SysDeptDao extends BaseMapper<SysDept> {

}