package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysLog)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:00
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLog> {

}