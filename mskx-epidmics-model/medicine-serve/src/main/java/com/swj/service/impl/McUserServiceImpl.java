package com.swj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.McUserDao;
import com.swj.entity.McUser;
import com.swj.service.McUserService;
import org.springframework.stereotype.Service;

/**
 * (McUser)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:05:28
 */
@Service("mcUserService")
public class McUserServiceImpl extends ServiceImpl<McUserDao, McUser> implements McUserService {

}