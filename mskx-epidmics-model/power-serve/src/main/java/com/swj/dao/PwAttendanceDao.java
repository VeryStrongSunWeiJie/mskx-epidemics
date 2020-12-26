package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.PwAttendance;
import org.apache.ibatis.annotations.Mapper;

/**
 * (PwAttendance)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:02:35
 */
@Mapper
public interface PwAttendanceDao extends BaseMapper<PwAttendance> {

}