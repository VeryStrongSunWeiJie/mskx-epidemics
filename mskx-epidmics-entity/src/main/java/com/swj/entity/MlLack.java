package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * (MlLack)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:34
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MlLack extends Model<MlLack> {
    //编号
    @TableId(type = IdType.AUTO)
    private Integer mlLid;
    //医院编号
    private Integer mlEid;
    //物资编号(缺乏指定物资)
    private Integer mlDid;
    //时间
    private Date mlCreatetime;
    //受理人
    private String mlApname;
    //受理时间
    private Date mlAptime;
    //备注，备注捐赠详细信息
    private String remark;

}