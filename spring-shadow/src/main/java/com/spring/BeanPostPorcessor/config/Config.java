package com.spring.BeanPostPorcessor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.spring.BeanPostPorcessor")
@EnableAspectJAutoProxy
public class Config {
}
