package com.spring.batis.util;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Import(CustomImportBeanDefinitionRegistart.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NXScan {
	String value();
}
