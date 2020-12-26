package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * (McUser)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:33
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class McUser extends Model<McUser> {
    //	人员编号
    @TableId(type = IdType.AUTO)
    private Integer opId;
    //人员名称
    private String opName;
    //入院时间
    private Date opEntertime;
    //	人员年龄
    private Integer opAge;
    //人员住院时长
    private Object opTime;
    //人员状态（0,健康、1.非健康、2.重病）
    private Integer opHealthy;
    //删除标记（0代表存在 2代表删除）
    private Integer opdelFlag;
    //出院时间
    private Date opOptime;
    //创建时间
    private Date opCreatetime;
    //创建者
    private String opCreateby;
    //更新者
    private Date opUpdatetime;
    //更新时间
    private Date opUpdateby;
    //备注
    private String remark;

}