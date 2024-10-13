package com.atguigu.service;

import com.atguigu.pojo.Schedule;
import com.atguigu.utils.PageBean;

public interface ScheduleService {

    PageBean<Schedule> findByPage(int pageSize, int currentPage);

    void saveSchedule(Schedule schedule);
    void removeById(Integer id);
    void updateSchedule(Schedule schedule);
}
