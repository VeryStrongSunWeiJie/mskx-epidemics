package com.swj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swj.entity.SysDept;

import java.util.List;

/**
 * 部门表(SysDept)表服务接口
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:00
 */
public interface SysDeptService extends IService<SysDept> {

    List<SysDept> getMenu();
}