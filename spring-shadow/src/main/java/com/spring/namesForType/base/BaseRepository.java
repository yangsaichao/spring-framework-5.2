package com.spring.namesForType.base;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/3114:30
 */

@Slf4j(topic = "e")
public class BaseRepository<T> {
	public T query() throws IllegalAccessException, InstantiationException {
		log.debug("current Repository={}",this);
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		Class<T> entityClass = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
		T t = entityClass.newInstance();
		log.debug("current Entity={}",t);
		return t;
	}
}
