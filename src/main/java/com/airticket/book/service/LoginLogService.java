package com.airticket.book.service;

import com.airticket.book.model.LoginLog;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */
public interface LoginLogService {
    List<LoginLog> findAllLoginLogs(Date startTime, Date endTime);

}
