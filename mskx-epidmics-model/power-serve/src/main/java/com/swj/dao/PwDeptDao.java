package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.PwDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * (PwDept)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:02:36
 */
@Mapper
public interface PwDeptDao extends BaseMapper<PwDept> {

}