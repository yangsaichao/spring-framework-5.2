package com.spring.extension.generic;

import com.spring.generic.sub.GenericMultiBasicSubClass;
import com.spring.generic.sub.GenericSingletonBasicSubClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/220:11
 */

@Slf4j(topic = "e")
public class TestGenericActualTypeArgument {

	/**
	 *
	 * 测试单个参数化类型（泛型）
	 * 获取 actualTypeArguments  参数的真实类型
	 * GenericSingletonBasicSubClass extends GenericSingetonBasicClass<GenericA>
	 */
	@Test
	public void testGenericSingletonBasicSubClass(){
		Class<GenericSingletonBasicSubClass> clazz = GenericSingletonBasicSubClass.class;
		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		for (Type actualTypeArgument : actualTypeArguments) {
			log.debug(actualTypeArgument.getTypeName());
		}
	}

	/**
	 * 获取多个参数化类型（泛型）
	 * 获取 actualTypeArguments  参数的真实类型
	 * GenericMultiBasicSubClass extends GenericMultiBasicClass<GenericA, GenericB>
	 */
	@Test
	public void testGenericMultitonBasicSubClass(){
		Class<GenericMultiBasicSubClass> clazz = GenericMultiBasicSubClass.class;
		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		for (Type actualTypeArgument : actualTypeArguments) {
			log.debug(actualTypeArgument.getTypeName());
		}
	}

}
