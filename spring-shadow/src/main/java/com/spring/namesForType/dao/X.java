package com.spring.namesForType.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/222:16
 */
public class X<T> {

	public void foo(){
		Class xClass = this.getClass();
		ParameterizedType p = (ParameterizedType) xClass.getGenericSuperclass();
		for (Type actualTypeArgument : p.getActualTypeArguments()) {
			System.out.println(actualTypeArgument.getTypeName());
		}
	}
	static class Y extends X<String>{
	}
	public static void main(String[] args) {
		Y x= new Y();
		x.foo();
	}
}
