package com.jxh.log;

import com.jxh.constant.SystemConstant;
import com.jxh.domain.Admin;
import com.jxh.domain.SystemLog;
import com.jxh.service.ISystemLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * @author meizh
 * 一个切面类
 */
@Slf4j //打印日志

@Aspect
@Component
public class LogService {

    @Autowired
    private ISystemLogService systemLogService;



    /**
     * 第二步：定义切点表达式，明确要对那些方法起作用（比如，只对com.bravo.demo.controller包的方法计算接口耗时）
     */
    @Pointcut("execution(* com.jxh.controller.*.*(..))")
    public void controllerPointcut() {
    }

    /**
     * 第三步：1.通过引用切点表达式，明确这个增强的应用规则。 2.编写增强逻辑
     *
     * @param proceedingJoinPoint 执行目标方法的参数
     * @return 返回目标方法的执行结果
     * @throws Throwable proceedingJoinPoint.proceed()方法抛出的异常
     */

    /*@Autowired
    private HttpServletRequest request;*/
    @Around(value = "controllerPointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //获取方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        //获取类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //获取ip
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //Objects.requireNonNull(attributes)，判断不为空，防止异常
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        String ip = request.getRemoteAddr();
        //获取时间
        String date = new SimpleDateFormat("yyyy年MM月dd日-HH:mm:ss").format(new Date());
        //获取session
        HttpSession session = attributes.getRequest().getSession();
        Object o = session.getAttribute(SystemConstant.ADMIN_IN_SESSION);
        Admin admin= (Admin) o;
        //Arrays.stream(SystemConstant.METHOD).anyMatch(methodName::startsWith)
        //java8 stream接口终端操作 anyMatch，allMatch，noneMatch
        //anyMatch：判断的条件里，任意一个元素成功，返回true
        //allMatch：判断条件里的元素，所有的都是，返回true
        //noneMatch：与allMatch相反，判断条件里的元素，所有的都不是，返回true
        if (admin!=null && Arrays.stream(SystemConstant.METHOD).anyMatch(methodName::startsWith)){
            SystemLog systemLog = new SystemLog();
            systemLog.setOperation_id(admin.getId());
            systemLog.setContent(ip+"在"+date+"操作了"+className+"的"+methodName+"方法");
            systemLogService.addSystemLog(systemLog);
        }
        log.debug("操作类>>>>>"+className);
        log.debug("操作方法>>>>>"+methodName);
        log.debug("ip>>>>>"+ip);
        log.debug(ip+"在"+date+"操作了"+className+"的"+methodName+"方法");
        //执行业务方法
//        Object result = proceedingJoinPoint.proceed();
//        return result;
        return proceedingJoinPoint.proceed();
    }
}
