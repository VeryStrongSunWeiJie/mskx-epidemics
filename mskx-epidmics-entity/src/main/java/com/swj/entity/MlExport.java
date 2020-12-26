package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * (MlExport)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:34
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MlExport extends Model<MlExport> {
    //医院编号
    @TableId(type = IdType.AUTO)
    private Integer mlEid;
    //	医院名称
    private String mlHospital;
    //备注（医院名称、信息等）
    private String remark;
}