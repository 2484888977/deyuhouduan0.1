package com.deyu.config;

import com.deyu.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.deyu.mapper.LogMapper;
import com.deyu.pojo.Syslog;
import com.deyu.pojo.ViewUser;
import com.deyu.util.UtilTools;
import com.deyu.util.aLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Aspect
@Component
@Order(1)
public class LogAspect {

    private String contentA;
    private String requestIpA;
    private Method method1;

    public String getContentA() {
        return contentA;
    }

    public void setContentA(String contentA) {
        this.contentA = contentA;
    }

    public String getRequestIpA() {
        return requestIpA;
    }

    public void setRequestIpA(String requestIpA) {
        this.requestIpA = requestIpA;
    }

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private ObjectMapper mapper;

    Logger log = LoggerFactory.getLogger(getClass());
    /**
     * 开始时间
     */
    private Long visitTime;
    /**
     * 访问的类
     */
    private Class clazz;
    /**
     * 访问的方法
     */
    private Method method;

    /**
     * 申明一个切点，里面是execution表达式
     */
    @Pointcut("execution(public * com.deyu.controller.*.*(..))")
    private void aspect() {
    }


    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        visitTime = System.currentTimeMillis();
        Date date = new Date(visitTime);
        clazz = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("=============请求内容=============");
        String requestMethod = request.getMethod();
        log.info("请求时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        log.info("请求IP:" + UtilTools.getRemoteIP(request));
        log.info("请求地址:" + request.getRequestURI());
        log.info("请求方式:" + requestMethod);
        log.info("请求类方法:" + joinPoint.getSignature());
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        String url = "";
        if (clazz != null && method != null) {
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation != null) {
                String[] classValues = clazzAnnotation.value();
                if ("GET".equals(requestMethod)) {
                    GetMapping methodAnnotation = method.getAnnotation(GetMapping.class);
                    url(classValues, methodAnnotation != null, methodAnnotation.value());
                } else {
                    PostMapping methodAnnotation = method.getAnnotation(PostMapping.class);
                    url(classValues, methodAnnotation != null, methodAnnotation.value());
                }
            }
            log.info("类名:{},方法名{}", clazz.getName(), methodName);
        }
        log.info("=============请求内容=============");

        contentA = request.getRequestURI();
        requestIpA = UtilTools.getRemoteIP(request);
        method1 = ((MethodSignature) joinPoint.getSignature()).getMethod();
    }

    @AfterReturning(returning = "obj", pointcut = "aspect()")
    public void methodAfterReturning(Object obj) {
        long time = System.currentTimeMillis() - visitTime;
        log.info("执行时间:{}ms", time);
        log.info("=============返回内容=============");
        try {
            log.info(mapper.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("发生错误", e);
        }
        log.info("=============返回内容=============");
        System.out.println("===============================++++++++++++++++++++");
        HttpServletRequest requestA = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("requestIpA：" + requestIpA);
        if (requestA.getSession().getAttribute("login_session") == null) {
            System.out.println("操作人信息为空");
            return;
        } else {
            User userA = ((User) requestA.getSession().getAttribute("login_session"));
            String Cname = userA.getUsername();
            String CID = userA.getUsername();
            if (!requestIpA.equals("0:0:0:0:0:0:0:1")) {
                Syslog syslog = new Syslog(0, Cname, CID, contentA, requestIpA);

                aLog Clog = method1.getAnnotation(aLog.class);
                if (Clog != null) {
                    syslog.setContent(Clog.value());
                    System.out.println(syslog);
                    int code = logMapper.addLog(syslog);
                }
            }
        }
        System.out.println("===============================++++++++++++++++++++");
    }

    private void url(String[] classValues, boolean b, String[] value) {
        String url;
        if (b) {
            url = classValues[0] + value[0];
            log.info("url:{}", url);
        }
    }

}


