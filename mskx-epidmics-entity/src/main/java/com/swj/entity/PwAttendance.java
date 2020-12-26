package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * (PwAttendance)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:34
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PwAttendance extends Model<PwAttendance> {
    //出勤编号
    @TableId(type = IdType.AUTO)
    private Integer aid;
    //出勤职工编号
    private Integer userId;
    //出勤开始时间
    private Date aStarttime;
    //出勤结束时间
    private Date aStoptime;
    //出勤内容
    private String aTask;
    //	是否完成指定内容(0完成，1未完成)
    private String aStatus;
    //	创建时间
    private Date aCreatetime;
    //创建者
    private String aCreateby;
    //更新时间
    private Date aUpdatetime;
    //更新者
    private String aUpdateby;



}