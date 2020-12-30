package com.swj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swj.dao.PwDeptDao;
import com.swj.entity.PwDept;
import com.swj.service.PwDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (PwDept)表服务实现类
 *
 * @author sunweijie
 * @since 2020-12-26 11:02:36
 */
@Service("pwDeptService")
public class PwDeptServiceImpl extends ServiceImpl<PwDeptDao, PwDept> implements PwDeptService {

    @Resource
    private PwDeptDao pwDeptDao;

    @Override
    public List<PwDept> getMenus() {
        //获取到所有数据
        List<PwDept> list = this.pwDeptDao.selectList(null);
        List<PwDept> collect = list.stream().filter(pwDept ->
                pwDept.getPwparentId() == 0
        ).map(pwDept -> {
            pwDept.setPwDepts(getMenusDown(pwDept, list));
            return pwDept;
        }).collect(Collectors.toList());
        return collect;
    }


    public List<PwDept> getMenusDown(PwDept pwDept, List<PwDept> all) {
        List<PwDept> collect = all.stream().filter(alls ->
                alls.getPwparentId() == pwDept.getPwdeptId()
        ).map(pwDept1 -> {
            pwDept1.setPwDepts(getMenusDown(pwDept1, all));
            return pwDept1;
        }).collect(Collectors.toList());
        return collect;
    }
}