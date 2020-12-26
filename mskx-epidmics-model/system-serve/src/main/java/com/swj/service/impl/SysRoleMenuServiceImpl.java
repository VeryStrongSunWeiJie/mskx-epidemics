package com.swj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.SysRoleMenuDao;
import com.swj.entity.SysRoleMenu;
import com.swj.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * (SysRoleMenu)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:03
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenu> implements SysRoleMenuService {

}