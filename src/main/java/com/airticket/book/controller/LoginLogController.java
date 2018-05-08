package com.airticket.book.controller;

import com.airticket.book.annotation.SwitchDataSource;
import com.airticket.book.model.LoginLog;
import com.airticket.book.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */
@RestController
@RequestMapping("loginLog")
public class LoginLogController {
    @Autowired
    private LoginLogService loginLogService;

    @GetMapping
    @SwitchDataSource(name = "master")
    public List<LoginLog> findAllLogs(@RequestParam @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss") Date startTime,
                               @RequestParam @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss") Date endTime) {
        return loginLogService.findAllLoginLogs(startTime, endTime);
    }

    @GetMapping("findLogs")
    @SwitchDataSource(name = "slave")
    public List<LoginLog> findLogs(@RequestParam @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss") Date startTime,
                                   @RequestParam @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss") Date endTime) {
        return loginLogService.findAllLoginLogs(startTime, endTime);
    }

}
