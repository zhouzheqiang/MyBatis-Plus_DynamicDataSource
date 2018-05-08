package com.zzq.pro.aop;

import com.zzq.pro.annotation.SwitchDataSource;
import com.zzq.pro.config.DBContextHolder;
import com.zzq.pro.config.DBTypeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(1)
public class DataSourceSwitchAspect {

    @Pointcut(value = "@annotation(com.zzq.pro.annotation.SwitchDataSource)")
    private void switchDataSource() {

    }

    @Around("switchDataSource()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = null;

        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }

        methodSignature = (MethodSignature) signature;

        Object target = point.getTarget();
        Method currentMethod =
                target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

        SwitchDataSource annotation = currentMethod.getAnnotation(SwitchDataSource.class);

        switch (annotation.name()) {
            case "master":
                DBContextHolder.setDBType(DBTypeEnum.MASTER);
                System.out.println("+++DataSource MASTER ++++");
                break;
            case "slave":
                DBContextHolder.setDBType(DBTypeEnum.SLAVE);
                System.out.println("+++DataSource slave ++++");
                break;
            default:
                break;
        }

        try {
            return point.proceed();
        }finally {
            DBContextHolder.clearDBType();
        }
    }

}
