package com.spring.generic;


import com.spring.generic.pojo.GenericB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/4/220:07
 */
public class GenericMultiBasicClass<T,T1> {
	private List<String> listParameterized;
	private List listNormal;
	Map<?,?> mapParameterized = new HashMap<>();
	Map mapNormal;
	GenericB.B_b<String> b_b;

}
