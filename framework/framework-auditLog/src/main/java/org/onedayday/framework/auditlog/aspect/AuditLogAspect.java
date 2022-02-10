package org.onedayday.framework.auditlog.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.onedayday.framework.auditlog.annotation.AuditLog;
import org.onedayday.framework.auditlog.entity.LogContent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: framework
 * @class: AuditLogAspect
 * @description:
 * @author: wdd
 * @create: 2022-02-08 17:13
 */
@Aspect
@Component
public class AuditLogAspect {

    @Value("${spring.application.name}")
    private String applicationName;

    private List<LogContent> LogContentList;

    @Pointcut("@within(auditLog) || @annotation(auditLog)")
    public void point(AuditLog auditLog) {
    }

    @SuppressWarnings("unchecked")
    @Before(value = "point(auditLog)", argNames = "joinPoint,auditLog")
    public void beforeMethod(JoinPoint joinPoint, AuditLog auditLog) {
        if (auditLog == null) {
            return;
        }
        LogContentList = new ArrayList<>();
        LogContent logContent = getLog(joinPoint);
        String object = auditLog.object();
        String detail = auditLog.detail();
        logContent.setDetail(detail);
        logContent.setObject(object);
        logContent.setBehavior(auditLog.behavior().getName());
        LogContentList.add(logContent);

    }

    @AfterReturning(value = "point(auditLog)", argNames = "auditLog,val", returning = "val")
    public void afterMethodReturning(AuditLog auditLog, Object val) {
        if (auditLog == null) {
            return;
        }
        try {
            for (LogContent logContent : LogContentList) {
                //TODO 此处保存至数据库或者发送mq
            }
        } catch (Exception e) {
        }
    }


    private LogContent getLog(JoinPoint joinPoint) {
        LogContent logContent = new LogContent();
        logContent.setOperatorTime(new Date());
        Object[] args = joinPoint.getArgs();
        List<Object> objectList = new ArrayList<>(args.length);
        for (Object arg : args) {
            boolean parse = parse(arg);
            if (parse) {
                objectList.add(arg);
            }
        }
        logContent.setArgs(JSON.toJSONString(objectList));
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logContent.setClassName(methodSignature.getDeclaringTypeName());
        logContent.setMethodName(methodSignature.getName());
        logContent.setApplicationName(applicationName);
        //此处增加用户信息
        return logContent;
    }

    /**
     * 数据是否可以序列化
     *
     * @param object
     * @return true
     */
    private boolean parse(Object object) {
        if (object instanceof HttpServletRequest) {
            return false;
        } else if (object instanceof HttpServletResponse) {
            return false;
        } else if (object instanceof MultipartFile) {
            return false;
        } else if (object instanceof OutputStream) {
            return false;
        }
        return true;
    }
}
