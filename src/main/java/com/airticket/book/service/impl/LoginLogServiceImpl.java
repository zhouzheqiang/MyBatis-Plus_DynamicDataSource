package com.airticket.book.service.impl;

import com.airticket.book.mapper.LoginLogMapper;
import com.airticket.book.model.LoginLog;
import com.airticket.book.service.LoginLogService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */
@Service
@Transactional
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public List<LoginLog> findAllLoginLogs(Date startTime, Date endTime) {
        return loginLogMapper.selectList(
                new EntityWrapper<LoginLog>()
                        .ge("loginTime", new DateTime(startTime).toString("YYYY-MM-dd HH:mm:ss"))
        .le("loginTime", new DateTime(endTime).toString("YYYY-MM-dd HH:mm:ss")));
    }

}
