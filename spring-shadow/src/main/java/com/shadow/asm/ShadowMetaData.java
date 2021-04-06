package com.shadow.asm;

import java.util.ArrayList;
import java.util.List;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2716:33
 */
public class ShadowMetaData {

	List<MergedAnnotation> list = new ArrayList<>();

	public void setList(List<MergedAnnotation> list) {
		this.list = list;
	}

	public List<MergedAnnotation> getList() {
		return list;
	}
}
