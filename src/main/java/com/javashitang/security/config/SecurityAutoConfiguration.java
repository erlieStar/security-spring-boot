package com.javashitang.security.config;

import com.javashitang.security.service.inf.UserRoleMenuService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * CommandLineRunner可以用来启动时执行任务
 */
//@Configuration
@MapperScan({"com.javashitang.security.dao"})
public class SecurityAutoConfiguration implements CommandLineRunner, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SecurityAutoConfiguration.class);

    @Autowired
    private UserRoleMenuService userRoleMenuService;

    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        // RequestMappingHandlerMapping是@RequestMapping的映射器
        RequestMappingHandlerMapping handlerMapping =  this.applicationContext.getBean(RequestMappingHandlerMapping.class);
        if (handlerMapping == null) {
            logger.error("can not found RequestMappingHandlerMapping");
        } else {
            this.userRoleMenuService.updateMenuInfo2Db(handlerMapping);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
