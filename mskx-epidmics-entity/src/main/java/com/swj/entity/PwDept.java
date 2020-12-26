package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * (PwDept)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:34
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PwDept extends Model<PwDept> {
    //部门编号
    @TableId(type = IdType.AUTO)
    private Integer pwdeptId;
    //父级编号
    private Integer pwparentId;
    //祖级列表
    private Integer pwancestors;
    //部门名称
    private String pwdeptName;
    //显示顺序
    private Integer pworderNum;
    //负责人
    private String pwleader;
    //联系电话
    private String pwphone;
    //部门状态（0正常 1停用）
    private String pwstatus;
    //删除标志（0代表存在 2代表删除）
    private String pwdelFlag;
    //创建者
    private String pwcreateBy;
    //创建时间
    private Date pwcreateTime;
    //更新者
    private String pwupdateBy;
    //更新时间
    private Date pwupdateTime;
    @TableField(exist = false)
    private List<PwDept> pwDepts;
}