package com.swj.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (MlLacks)表实体类
 *
 * @author sunweijie
 * @since 2021-01-13 15:08:50
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MlLacks extends Model<MlLacks> {
    //缺乏编号
    private Integer mlLid;
    //缺乏物资内容
    private String mlLname;
    //缺乏物资状态：急缺、不急
    private Integer mlLstate;
    //时间
    private Date mlCreatetime;
    //医院名称
    private Integer mlEid;
    //是否完成
    private Integer mlIscomplete;
    //受理人
    private String mlApname;
    //受理时间
    private Date mlAptime;
    //简介
    private String remark;


}