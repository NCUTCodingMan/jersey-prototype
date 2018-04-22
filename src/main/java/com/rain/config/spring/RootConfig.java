package com.rain.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author rain
 * created on 2018/4/22
 */
@Configuration
@ComponentScan(basePackages = {"com.rain.util", "com.rain.rest"})
public class RootConfig {

}