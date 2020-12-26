package com.swj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.PwDeptDao;
import com.swj.entity.PwDept;
import com.swj.service.PwDeptService;
import org.springframework.stereotype.Service;

/**
 * (PwDept)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:02:36
 */
@Service("pwDeptService")
public class PwDeptServiceImpl extends ServiceImpl<PwDeptDao, PwDept> implements PwDeptService {

}