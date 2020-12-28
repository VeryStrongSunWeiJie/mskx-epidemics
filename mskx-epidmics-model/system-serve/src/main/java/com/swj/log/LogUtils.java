package com.swj.log;

import com.swj.entity.SysLog;
import com.swj.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class LogUtils {
    @Resource
    private SysLogService sysLogService;

    /**
     * 标注注解的地方都会被答应日志
     */
    @Pointcut("@annotation(com.swj.log.SysLog)")
    public void logPointCut() {
    }

    /**
     * 登录暂时未作
     */
    //@Pointcut("execution(* com.swj.security.SecurityDatilService.*(..))")
    public void checkTim() {
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
            Date date = new Date();
            SysLog sysLog = new SysLog();
            sysLog.setLogDatetime(date);
            sysLog.setLogAddress(localHost.getHostAddress());
            sysLog.setLogAuthor("当前用户");
            sysLog.setRemark(methodName);
            sysLog.setLogDescribe(e.getMessage());
            sysLog.setLogName(message);
            boolean save = sysLogService.save(sysLog);
            if (save) {
                log.info("成功");
            } else {
                log.error("失败");
            }
        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } finally {
            log.info("日志记录成功了");
        }
        return map;
    }


  /*  @AfterReturning(pointcut = "checkTim()")
    public void check(JoinPoint joinPoint) throws UnknownHostException {
        //获取ip地址
        InetAddress localHost = InetAddress.getLocalHost();
        SysLog sysActionLog = new SysLog();
        sysActionLog.setLogName("登录增强");
        sysActionLog.setRemark("login");
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        sysActionLog.setLogAddress(localHost.getHostAddress());
        sysActionLog.setLogAuthor("admin");
        sysActionLog.setLogDescribe("用户登录方法：" + methodName + "begins with" + Arrays.asList(args));
        boolean save = sysLogService.save(sysActionLog);
        if (save) {
            log.info("成功");
        } else {
            log.error("失败");
        }
    }
*/
}
