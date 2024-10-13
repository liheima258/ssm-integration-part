package com.atguigu.service.impl;

import com.atguigu.mapper.ScheduleMapper;
import com.atguigu.pojo.Schedule;
import com.atguigu.service.ScheduleService;
import com.atguigu.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ScheduleServiceImpl  implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;

    /**
     * 分页数据查询,返回分页pageBean
     */
    @Override
    public PageBean<Schedule> findByPage(int pageSize, int currentPage) {
        //1.设置分页参数
        PageHelper.startPage(currentPage,pageSize);
        //2.数据库查询
        List<Schedule> list = scheduleMapper.queryPage();
        //3.结果获取
        PageInfo<Schedule> pageInfo = new PageInfo<>(list);
        //4.pageBean封装
        PageBean<Schedule> pageBean = new PageBean<>(pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal(),pageInfo.getList());

        log.info("分页查询结果:{}",pageBean);

        return pageBean;
    }

    /**
     * 保存
     */
    @Override
    public void saveSchedule(Schedule schedule) {
        scheduleMapper.insert(schedule);
    }

    /**
     * 删除
     */
    @Override
    public void removeById(Integer id) {
        scheduleMapper.delete(id);
    }


    /**
     * 更新
     */
    @Override
    public void updateSchedule(Schedule schedule) {
        scheduleMapper.update(schedule);
    }

}