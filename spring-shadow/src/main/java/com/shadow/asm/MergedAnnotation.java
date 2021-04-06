package com.shadow.asm;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2716:30
 */
public class MergedAnnotation {
	Class annotationType;
	String source;

	public void setAnnotationType(Class annotationType) {
		this.annotationType = annotationType;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Class getAnnotationType() {
		return annotationType;
	}

	public String getSource() {
		return source;
	}
}
