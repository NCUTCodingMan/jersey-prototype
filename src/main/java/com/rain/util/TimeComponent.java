package com.rain.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间组件
 * @author rain
 * created on 2018/4/22
 */
@Component
public class TimeComponent {
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
        return sdf.format(new Date());
    }
}