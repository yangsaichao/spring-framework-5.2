package com.spring.generic.sub;

import com.spring.generic.GenericSingetonBasicClass;
import com.spring.generic.pojo.GenericA;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/219:48
 */

@Slf4j(topic = "e")
public class GenericSingletonBasicSubClass extends GenericSingetonBasicClass<GenericA> {

	public static void main(String[] args) {
		Class<GenericSingletonBasicSubClass> clazz = GenericSingletonBasicSubClass.class;
		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		Type rawType = parameterizedType.getRawType();
		System.out.println(rawType.getTypeName());
	}
}
