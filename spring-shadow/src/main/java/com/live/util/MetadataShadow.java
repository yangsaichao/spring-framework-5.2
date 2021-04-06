package com.live.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/2721:52
 *
 * 我们整个类的新消息
 */
public class MetadataShadow {

	List<AnnoMetaDataShadow> list = new ArrayList<>();

	String claName;

	public List<AnnoMetaDataShadow> getList() {
		return list;
	}

	public void setList(List<AnnoMetaDataShadow> list) {
		this.list = list;
	}

	public String getClaName() {
		return claName;
	}

	public void setClaName(String claName) {
		this.claName = claName;
	}
}
