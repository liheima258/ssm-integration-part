package com.atguigu.controller;

import com.atguigu.pojo.Schedule;
import com.atguigu.service.ScheduleService;
import com.atguigu.utils.PageBean;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
    @CrossOrigin 注释在带注释的控制器方法上启用跨源请求
 */
@CrossOrigin
@RequestMapping("schedule")
@RestController
public class ScheduleController
{

    @Autowired
    private ScheduleService scheduleService;

    //分页查询
    @GetMapping("/{pageSize}/{currentPage}")
    public R showList(@PathVariable(name = "pageSize") int pageSize, @PathVariable(name = "currentPage") int currentPage){
        PageBean<Schedule> pageBean = scheduleService.findByPage(pageSize,currentPage);
        return  R.ok(pageBean);
    }

    //添加
    @PostMapping
    public R saveSchedule(@RequestBody Schedule schedule){
        scheduleService.saveSchedule(schedule);
        return R.ok(null);
    }

    //删除
    @DeleteMapping("/{id}")
    public R removeSchedule(@PathVariable Integer id){
        scheduleService.removeById(id);
        return R.ok(null);
    }

    //修改
    @PutMapping
    public R changeSchedule(@RequestBody Schedule schedule){
        scheduleService.updateSchedule(schedule);
        return R.ok(null);
    }
}    