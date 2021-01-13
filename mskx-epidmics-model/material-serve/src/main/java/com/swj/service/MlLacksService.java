package com.swj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swj.entity.MlLacks;
import com.swj.vo.MlLacksVo;

import java.util.List;
import java.util.Map;

/**
 * (MlLacks)表服务接口
 *
 * @author sunweijie
 * @since 2021-01-13 15:10:36
 */
public interface MlLacksService extends IService<MlLacks> {

    List<MlLacksVo> getMlLacksAll(Map<String, Object> map);
}