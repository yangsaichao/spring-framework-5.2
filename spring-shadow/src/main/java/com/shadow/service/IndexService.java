package com.shadow.service;

import com.shadow.dao.IndexDao;
import com.shadow.dao.IndexDao1;
import com.shadow.dao.IndexDaon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;



public class IndexService {

	//从spring容器当中拿出来自动注入
	//对象  不是接口
	@Autowired
	IndexDao indexDao;

	@Autowired
	IndexDao1 indexDao1;

	@Autowired
	IndexDaon indexDaon;



	public List<Map<String,Object>> list(){
		//查询数据库
		List<Map<String, Object>> list = indexDao.list();
		List<Map<String, Object>> list1 = indexDao1.list();
		indexDaon.list();
		return null;
	};
}
