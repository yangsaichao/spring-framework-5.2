package com.spring.extension.generic;

import com.spring.generic.GenericMultiBasicClass;
import com.spring.generic.sub.GenericMultiBasicSubClass;
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
public class TestGenericRawType {

	/**
	 *
	 * 直接定义在一个类上面的
	 * 获取 RawType  泛型所在的具体类的类型
	 * GenericSingletonBasicSubClass extends GenericSingetonBasicClass<GenericA>
	 */
	@Test
	public void testClassRawType(){
		Class<GenericSingletonBasicSubClass> clazz = GenericSingletonBasicSubClass.class;
		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		Type rawType = parameterizedType.getRawType();
		log.debug(rawType.getTypeName());
	}

	/**
     * 获取定义在属性当中的
	 * 获取 RawType  泛型所在的具体类的类型
	 * GenericMultiBasicSubClass extends GenericMultiBasicClass<GenericA, GenericB>
	 */
	@Test
	public void testFieldRawType(){
		Class<GenericMultiBasicClass> clazz = GenericMultiBasicClass.class;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if(field.getGenericType() instanceof ParameterizedType) {
				ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
				log.debug("{}的RawType={}", field.getName(), parameterizedType.getRawType());
				int psize =  parameterizedType.getActualTypeArguments().length;
				Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
				log.debug("{}的有{}个参数", field.getName(), psize);
				for (int i = 1; i < psize+1; i++) {
					log.debug("第{}个参数的类型={}", i, actualTypeArguments[i-1].getTypeName());
				}

			}
		}

	}

}
