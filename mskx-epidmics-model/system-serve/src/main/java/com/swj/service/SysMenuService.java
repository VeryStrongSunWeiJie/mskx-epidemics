package com.swj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swj.entity.SysMenu;

import java.util.List;

/**
 * (SysMenu)表服务接口
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:01
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> getThreeLevelMenu(Integer roleID);
}