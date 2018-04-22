package com.rain.config.jersey;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * 配置jersey资源路径信息, 类似配置了Servlet, /rest/*资源路径将会得到拦截
 * @author rain
 * created on 2018/4/22
 */
@ApplicationPath("rest")
public class ResourceInitializer extends ResourceConfig {
    public ResourceInitializer() {
        packages("com.rain.rest");
    }
}