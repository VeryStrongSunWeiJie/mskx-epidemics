package com.swj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.SysLogDao;
import com.swj.entity.SysLog;
import com.swj.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * (SysLog)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:01
 */
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLog> implements SysLogService {

}