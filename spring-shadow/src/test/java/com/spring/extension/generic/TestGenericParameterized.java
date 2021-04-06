package com.spring.extension.generic;

import com.spring.generic.GenericMultiBasicClass;
import com.spring.generic.pojo.GenericA;
import com.spring.generic.pojo.GenericAa;
import com.spring.generic.sub.GenericMultiBasicSubClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/220:28
 */
@Slf4j(topic = "e")
public class TestGenericParameterized {

	/**
	 * 测试一个类 或者属性 是否ParameterizedType
	 */
	@Test
	public void testParamterized(){
		Class<GenericMultiBasicClass> clazz = GenericMultiBasicClass.class;
		Class<GenericMultiBasicSubClass> sclazz =  GenericMultiBasicSubClass.class;
		Type genericSuperclass = sclazz.getGenericSuperclass();
		//判断 GenericMultiBasicClass是否一个参数化的类型
		if(genericSuperclass instanceof ParameterizedType) {
			log.debug("GenericMultiBasicClass is ParameterizedType");
		}

		Class<GenericAa> a = GenericAa.class;

		Type genericSuperclass1 = a.getGenericSuperclass();

		if(genericSuperclass1 instanceof ParameterizedType) {
			log.debug("GenericA is ParameterizedType");
		}


		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			Type genericType = field.getGenericType();
			if (genericType instanceof ParameterizedType){
				log.debug(field.getName()+" is ParameterizedType!");
			}
		}
	}



}
