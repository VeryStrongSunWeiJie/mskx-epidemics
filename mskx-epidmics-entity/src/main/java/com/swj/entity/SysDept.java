package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * 部门表(SysDept)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:35
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysDept extends Model<SysDept> {
    //部门id
    @TableId(type = IdType.AUTO)
    private Long deptId;
    //父部门id
    private Long parentId;
    //祖级列表
    private String ancestors;
    //部门名称
    private String deptName;
    //显示顺序
    private Integer orderNum;
    //负责人
    private String leader;
    //联系电话
    private String phone;
    //邮箱
    private String email;
    //部门状态（0正常 1停用）
    private String status;
    //删除标志（0代表存在 2代表删除）
    private String delFlag;
    //创建者
    private String createBy;
    //创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    @TableField(exist = false)
    private List<SysDept> sysDepts;
}