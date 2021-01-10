package com.swj.vo;

import com.swj.entity.SysRole;
import lombok.Data;

@Data
public class SysUserVo {
    private Long id;
    private String nickName;
    private String sex;
    private String email;
    private String phonenumber;
    private String avatar;
    private String createTime;
    //用户身份
    private String roleName;
}
