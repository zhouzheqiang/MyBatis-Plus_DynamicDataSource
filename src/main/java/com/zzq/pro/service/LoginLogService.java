package com.zzq.pro.service;

import com.zzq.pro.model.LoginLog;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */
public interface LoginLogService {
    List<LoginLog> findAllLoginLogs(Date startTime, Date endTime);

}
