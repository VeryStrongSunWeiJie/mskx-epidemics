package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * (SysRole)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 11:07:00
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysRole extends Model<SysRole> {
    //角色ID
    @TableId(type = IdType.AUTO)
    private Integer roleId;
    //角色名称
    private String roleName;
    //角色权限字符串
    private String roleKey;
    //角色状态（0正常 1停用）
    private String roleStatus;
    //删除标志（0代表存在 2代表删除）
    private String delFlag;
    //创建者
    private String createBy;
    //创建时间
    private Date createTime;


}