package com.swj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.SysDeptDao;
import com.swj.entity.SysDept;
import com.swj.service.SysDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门表(SysDept)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:01:00
 */
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDept> implements SysDeptService {

    @Resource
    private SysDeptDao sysDeptDao;

    @Override
    public List<SysDept> getMenu() {
        //获取所有部门信息
        List<SysDept> sysDepts = this.sysDeptDao.selectList(null);
        List<SysDept> collect = sysDepts.stream().filter(sysDept ->
                sysDept.getParentId() == 0
        ).map((dept) -> {
            dept.setSysDepts(getMenu2(dept, sysDepts));
            return dept;
        }).collect(Collectors.toList());
        return collect;
    }

    private List<SysDept> getMenu2(SysDept sysDept, List<SysDept> all) {
        List<SysDept> collect = all.stream().filter(sysDept1 ->
                sysDept1.getParentId() == sysDept.getDeptId()
        ).map((dept) -> {
            dept.setSysDepts(getMenu2(dept, all));
            return dept;
        }).collect(Collectors.toList());
        return collect;
    }
}