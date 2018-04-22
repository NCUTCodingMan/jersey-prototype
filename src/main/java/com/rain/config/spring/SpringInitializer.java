package com.rain.config.spring;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 为什么需要配置这个Servlet, 告诉jersey不要找applicationContext.xml初始化Spring容器
 * 这是一个bug
 *
 * The important thing to note about this components is the @Order(1).
 * We want to make sure this initializer occurs before Jersey tries to create the app context.
 * If we fail to do this, Jersey will look for a applicationContext.xml Spring configuration file.
 * When it does not find it we will get a FileNotFoundException. Since we don’t want to use xml configuration,
 * we need to include the initializer.
 *
 * Annotation Order用来调整配置类的加载顺序
 *
 * @author rain
 * created on 2018/4/22
 */
@Order(1)
public class SpringInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("contextConfigLocation", "noop");
    }
}