package com.swj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * (MlDetailed)表实体类
 *
 * @author sunweijie
 * @since 2020-12-25 10:36:33
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MlDetailed extends Model<MlDetailed> {
    //物资编号
    @TableId(type = IdType.AUTO)
    private Integer mlDid;
    //物资名称
    private String mlDname;
    //物资类型
    private Integer mlTid;
    //物品重量（斤）
    private Integer mlQuality;
    //来自城市
    private String mlCity;
    //指定捐赠地点（可以为null）
    private String mlPlace;
    //创建时间、捐赠时间
    private Date mlCreatetime;
    //创建人
    private String mlCreateby;
    //修改时间
    private Date mlUpdatetime;
    //修改人
    private String mlUpdateby;
    //备注（捐赠人、城市等等信息）
    private String remark;

}