package com.swj.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MlLacksVo {
    //编号
    private Integer mlLid;
    //缺乏物资信息
    private String mlLName;
    //时间
    private Date mlCreateTime;
    //缺乏状态
    private String mlLState;
    //是否完成
    private String mlIsComplete;
    //医院名称
    private String mlEName;
}
