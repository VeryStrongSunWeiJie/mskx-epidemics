package com.swj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.SysMenuDao;
import com.swj.dao.SysRoleMenuDao;
import com.swj.entity.SysMenu;
import com.swj.entity.SysRole;
import com.swj.entity.SysRoleMenu;
import com.swj.log.SysLog;
import com.swj.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (SysMenu)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:01
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Resource
    private SysRoleMenuDao sysRoleMenuDao;

    @Resource
    private SysMenuDao sysMenuDao;
   
    @Override
    public List<SysMenu> getThreeLevelMenu(Integer roleID) {
        //根据id获取用户所有权限
        List<SysMenu> sysMenuByRoleId = this.sysMenuDao.findSysMenuByRoleId(roleID);
        //编写三级菜单
        List<SysMenu> collect = sysMenuByRoleId.stream().filter(sysMenu ->
                sysMenu.getParentId() == 0
        ).map((map) -> {
            map.setChildren(getSidebar(map, sysMenuByRoleId));
            return map;
        }).sorted((menu1, menu2) -> {
            return ((menu1.getOrderNum() == null ? 0 : menu1.getOrderNum()) - (menu2.getOrderNum() == null ? 0 : menu2.getOrderNum()));
        }).collect(Collectors.toList());
        return collect;
    }

    /**
     * 递归查询根节点下面的节点
     * @param sysMenu   当前数据
     * @param all   所有数据
     * @return
     */
    private List<SysMenu> getSidebar(SysMenu sysMenu, List<SysMenu> all) {
        List<SysMenu> collect = all.stream().filter(sysMenu1 -> {
            return sysMenu1.getParentId() == sysMenu.getMenuId();
        }).map((entityClass) -> {
            entityClass.setChildren(getSidebar(entityClass, all));
            return entityClass;
        }).sorted((menu1, menu2) -> {
            return ((menu1.getOrderNum() == null ? 0 : menu1.getOrderNum()) - (menu2.getOrderNum() == null ? 0 : menu2.getOrderNum()));
        }).collect(Collectors.toList());

        return collect;
    }
}