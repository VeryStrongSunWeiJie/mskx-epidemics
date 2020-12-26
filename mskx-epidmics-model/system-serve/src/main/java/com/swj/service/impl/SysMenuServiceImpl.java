package com.swj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.SysMenuDao;
import com.swj.entity.SysMenu;
import com.swj.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * (SysMenu)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:01
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

}