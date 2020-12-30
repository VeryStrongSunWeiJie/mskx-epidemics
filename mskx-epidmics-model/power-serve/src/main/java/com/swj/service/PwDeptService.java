package com.swj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swj.entity.PwDept;

import java.util.List;

/**
 * (PwDept)表服务接口
 *
 * @author sunweijie
 * @since 2020-12-26 11:02:36
 */
public interface PwDeptService extends IService<PwDept> {

    List<PwDept> getMenus();
}