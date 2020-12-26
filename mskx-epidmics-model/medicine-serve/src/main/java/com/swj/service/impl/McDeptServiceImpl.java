package com.swj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.McDeptDao;
import com.swj.entity.McDept;
import com.swj.service.McDeptService;
import org.springframework.stereotype.Service;

/**
 * (McDept)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:05:28
 */
@Service("mcDeptService")
public class McDeptServiceImpl extends ServiceImpl<McDeptDao, McDept> implements McDeptService {

}