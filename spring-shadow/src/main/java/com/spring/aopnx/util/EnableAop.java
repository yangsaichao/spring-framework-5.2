package com.spring.aopnx.util;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(NxBeanPostProcessor.class)
public @interface EnableAop {
}
