package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * (McDept)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:32
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class McDept extends Model<McDept> {
    //部门编号
    @TableId(type = IdType.AUTO)
    private Integer mcdeptId;
    //	父级编号
    private Integer mcparentId;
    //祖级列表
    private String mcancestors;
    //部门名称
    private String mcdeptName;
    //显示顺序
    private Integer mcorderNum;
    //负责人
    private String mcleader;
    //联系电话
    private String mcphone;
    //部门状态（0正常 1停用）
    private Integer mcstatus;
    //删除标志（0代表存在 2代表删除）
    private Integer mcdelFlag;
    //创建者
    private String mccreateBy;
    //创建时间
    private Date mccreateTime;
    //更新者
    private String mcupdateBy;
    //	更新时间
    private Date mcupdateTime;

    @TableField(exist = false)
    private List<McDept> mcDepts;
}