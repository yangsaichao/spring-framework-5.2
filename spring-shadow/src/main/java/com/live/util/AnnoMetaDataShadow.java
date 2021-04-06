package com.live.util;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2721:52
 * 存放注解的信息
 */
public class AnnoMetaDataShadow {
	//注解类型
	Class annotationType;
	//那个类
	String source;
	//注解的名字
	String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSource(String source) {
		this.source = source;
	}



	public String getSource() {
		return source;
	}

	public void setAnnotationType(Class annotationType) {
		this.annotationType = annotationType;
	}

	public Class getAnnotationType() {
		return annotationType;
	}
}
