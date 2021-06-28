package com.spring.earlyBean.anno;

import com.spring.earlyBean.beanPostProcessor.AopBeanPostProcessor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(AopBeanPostProcessor.class)
public @interface EnableAopAutoProxyCreator {
}
