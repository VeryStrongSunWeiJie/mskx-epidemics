package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.McDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * (McDept)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:05:27
 */
@Mapper
public interface McDeptDao extends BaseMapper<McDept> {

}