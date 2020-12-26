package com.swj.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * (SysUserRole)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 11:07:02
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysUserRole extends Model<SysUserRole> {
    //	用户ID
    private SysUser userId;
    //角色ID
    private SysRole roleId;

}