package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * (SysLog)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 11:04:27
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysLog extends Model<SysLog> {
    //日志编号
    @TableId(type = IdType.AUTO)
    private Integer logId;
    //	日志名称
    private String logName;
    //	日志描述
    private String logDescribe;
    //日志信息地址
    private String logAddress;
    //产生时间
    private Date logDatetime;
    //产生用户
    private String logAuthor;
    //日志备注
    private String remark;


}