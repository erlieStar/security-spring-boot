package com.javashitang.security.autoconfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(SecurityMarkerConfiguration.Marker.class)
@MapperScan({"com.javashitang.security.dao"})
public class SecurityAutoConfiguration implements CommandLineRunner, ApplicationListener {

    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {

    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        this.applicationContext = applicationContext;
    }
}
