package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * (MlType)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:34
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MlType extends Model<MlType> {
    //类型编号
    @TableId(type = IdType.AUTO)
    private Integer mlTid;
    //类型名称
    private String mlTname;
    //创建时间
    private Date mlCreatetime;
    //创建人
    private String mlCreateby;
    //修改时间
    private Date mlUpdatetime;
    //修改人
    private String mlUpdateby;
    //备注
    private String remark;
}