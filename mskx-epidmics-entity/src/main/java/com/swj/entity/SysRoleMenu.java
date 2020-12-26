package com.swj.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * (SysRoleMenu)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 11:07:01
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysRoleMenu extends Model<SysRoleMenu> {
    //角色ID
    private SysRole roleId;
    //菜单ID
    private SysMenu menuId;


}