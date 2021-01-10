package com.swj.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * (SysMenu)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 11:07:00
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysMenu extends Model<SysMenu> {
    //菜单ID
    @TableId(type = IdType.AUTO)
    private Integer menuId;
    //菜单名称
    private String menuName;
    //父菜单ID
    private Integer parentId;
    //显示顺序
    private Integer orderNum;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //菜单状态（0正常 1停用）
    private String status;
    //	权限标识
    private String perms;
    //	菜单图标
    private String icon;
    //	创建者
    private String createBy;
    //	创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;

    @TableField(exist = false)
    private List<SysMenu> children;
}