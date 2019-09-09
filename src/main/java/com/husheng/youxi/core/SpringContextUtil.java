package com.husheng.youxi.core;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

/**
 * 从Spring容器中取得对象
 * @author weiyuan
 *
 */
public class SpringContextUtil implements ApplicationContextAware,
        ServletContextAware {

    private static ApplicationContext applicationContext; // Spring上下文对象.静态变量,可在任何代码任何地方任何时候中取出ApplicaitonContext. 

    private static ServletContext servletContext;// 注入 系统上下文对象
    
    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     * 
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象
     * 
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * 功能 : 实现 ServletContextAware接口,由Spring自动注入 系统上下文对象
     * 
     **/
    public void setServletContext(ServletContext servletContext) {
        SpringContextUtil.servletContext = servletContext;
    }

    /**
     * @return ServletContext
     */
    public static ServletContext getServletContext() {
        return servletContext;
    }
}
