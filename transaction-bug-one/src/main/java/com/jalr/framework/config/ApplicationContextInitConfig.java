package com.jalr.framework.config;

import com.jalr.framework.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import sun.plugin.viewer.context.DefaultPluginAppletContext;

import java.util.Objects;

/**
 * @author zhanwenliang [routerhex@qq.com]
 * @description
 * @date 2020-10-23 16:29
 */
@Slf4j
@Configuration
public class ApplicationContextInitConfig implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        log.warn("Spring context info: {}", applicationContext.getClass().toString());
//        if (Objects.isNull(SpringContextUtil.getApplicationContext())) {
//            SpringContextUtil.initApplicationContext(applicationContext);
//        }
        SpringContextUtil.initApplicationContext(applicationContext);
    }
}
