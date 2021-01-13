package com.swj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.MlExportDao;
import com.swj.dao.MlLacksDao;
import com.swj.entity.MlExport;
import com.swj.entity.MlLacks;
import com.swj.service.MlLacksService;
import com.swj.vo.MlLacksVo;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (MlLacks)表服务实现类
 *
 * @author sunweijie
 * @since 2021-01-13 15:10:36
 */
@Service("mlLacksService")
public class MlLacksServiceImpl extends ServiceImpl<MlLacksDao, MlLacks> implements MlLacksService {

    @Resource
    private MlLacksDao mlLacksDao;

    @Resource
    private MlExportDao mlExportDao;

    @Override
    public List<MlLacksVo> getMlLacksAll(Map<String, Object> map) {
        //分页
        int pageIndex = Integer.parseInt(map.get("pageIndex").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        Page<MlLacks> page = new Page<MlLacks>(pageIndex,pageSize);
        //获取到急缺所有信息
        QueryWrapper<MlLacks> wrapper=new QueryWrapper<>();
        if (map.get("mlLState").toString()!=""||map.get("mlLState").toString().length()>0){
            wrapper.eq("ml_lState",map.get("mlLState").toString());
        }
        List<MlLacks> records = this.mlLacksDao.selectPage(page, wrapper).getRecords();
        //映射返回需要的类型
        List<MlLacksVo> collect = records.stream().map((item) -> {
            MlLacksVo mlLacksVo = new MlLacksVo();
            mlLacksVo.setMlCreateTime(item.getMlCreatetime());
            mlLacksVo.setMlLName(item.getMlLname());
            mlLacksVo.setMlIsComplete(item.getMlIscomplete().toString());
            mlLacksVo.setMlLid(item.getMlLid());
            mlLacksVo.setMlLState(item.getMlLstate().toString());
            //根据编号查询医院名称
            MlExport mlExport = this.mlExportDao.selectById(item.getMlEid());
            mlLacksVo.setMlEName(mlExport.getMlHospital());
            return mlLacksVo;
        }).collect(Collectors.toList());
        return collect;
    }
}