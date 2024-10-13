package com.atguigu.mapper;

import com.atguigu.pojo.Schedule;

import java.util.List;

public interface ScheduleMapper {

    List<Schedule> queryPage();
    void insert(Schedule schedule);
    void delete(Integer id);
    void update(Schedule schedule);
}    