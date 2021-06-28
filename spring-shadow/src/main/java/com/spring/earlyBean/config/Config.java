package com.spring.earlyBean.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@Configuration
@ComponentScan("com.spring.earlyBean")
//导入一个后置处理器---主要就能解析切面（用aspectj的注解来开发）
public class Config {
}
