package com.swj.Util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class LogUtil {

    /**
     * 标注注解的地方都会被答应日志
     */
    @Pointcut("@annotation(com.swj.Util.SysLog)")
    public void logPointCut() {
    }

    /**
     * 日志记录错误信息
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public Map<String, Object> ErrorsLog(JoinPoint joinPoint, Exception e) {
        //记录成为Map集合
        Map<String, Object> map = new HashMap<>();
        try {
            //获取ip地址
            InetAddress localHost = InetAddress.getLocalHost();
            //错误方法名
            String methodName = joinPoint.getSignature().getName();
            //错误相信信息
            String message = e.getMessage();
            //获取当前时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
            LocalDateTime now = LocalDateTime.now();
            Date parse = simpleDateFormat.parse(now.toString());
            map.put("localHost", localHost);
            map.put("methodName", methodName);
            map.put("message", message);
            map.put("parse", parse);
        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        } finally {
            log.info("日志记录成功了");
        }
        return map;
    }
}
