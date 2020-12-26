package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * (MlExportDetailed)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:34
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MlExportDetailed extends Model<MlExportDetailed> {
    //编号
    @TableId(type = IdType.AUTO)
    private Integer mlEdid;
    //医院编号
    private Integer mlEid;
    //物资编号
    private Integer mlDid;
    //捐赠时间
    private Date mlCreatetime;
    //备注，备注捐赠详细信息
    private String remark;

}