package com.swj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.PwAttendanceDao;
import com.swj.entity.PwAttendance;
import com.swj.service.PwAttendanceService;
import org.springframework.stereotype.Service;

/**
 * (PwAttendance)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:02:36
 */
@Service("pwAttendanceService")
public class PwAttendanceServiceImpl extends ServiceImpl<PwAttendanceDao, PwAttendance> implements PwAttendanceService {

}