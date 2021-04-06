package com.spring.namesForType.base;

import com.spring.namesForType.entity.MemberEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/3114:43
 */
@Slf4j(topic = "e")
public class BaseService<T> {
	@Autowired
	BaseRepository<T> baseRepository;

	public void query(){
		log.debug("service baseRepository");
		try {
			baseRepository.query();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
