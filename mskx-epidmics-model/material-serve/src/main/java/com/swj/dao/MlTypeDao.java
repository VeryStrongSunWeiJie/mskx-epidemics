package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.MlType;
import org.apache.ibatis.annotations.Mapper;

/**
 * (MlType)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:04:58
 */
@Mapper
public interface MlTypeDao extends BaseMapper<MlType> {

}