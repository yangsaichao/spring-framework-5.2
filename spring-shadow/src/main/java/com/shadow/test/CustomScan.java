package com.shadow.test;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(CustomImportBeanDefinitionRegistart.class)
public @interface CustomScan {
	String value() default "com.sahdo";
}
