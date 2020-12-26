package com.swj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swj.entity.McUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * (McUser)表数据库访问层
 *
 * @author sunweijie
 * @since 2020-12-26 11:05:28
 */
@Mapper
public interface McUserDao extends BaseMapper<McUser> {

}