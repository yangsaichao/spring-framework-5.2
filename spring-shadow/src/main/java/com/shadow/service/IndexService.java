package com.shadow.service;

import com.shadow.dao.IndexDao;
import com.shadow.dao.IndexDao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class IndexService {

	//从spring容器当中拿出来自动注入
	//对象  不是接口
	@Autowired
	IndexDao1 indexDao;



	public List<Map<String,Object>> list(){
		indexDao.list();
		return null;
	};
}
