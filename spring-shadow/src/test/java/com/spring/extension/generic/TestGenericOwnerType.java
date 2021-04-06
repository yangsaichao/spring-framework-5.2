package com.spring.extension.generic;

import com.spring.generic.GenericMultiBasicClass;
import com.spring.generic.pojo.GenericB;
import com.spring.generic.sub.GenericSingletonBasicSubClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/220:11
 */

@Slf4j(topic = "e")
public class TestGenericOwnerType {

	/**
	 *
	 * 获取 ownerType
	 * public class B_b<T>
	 */
	@Test
	public void testClassOwnerType(){
		Class<GenericMultiBasicClass> clazz = GenericMultiBasicClass.class;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if(field.getGenericType() instanceof ParameterizedType) {
				ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
				log.debug("{}的owner={}", field.getName(), parameterizedType.getOwnerType());
			}
		}

	}


}
