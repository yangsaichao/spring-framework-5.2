package com.spring.namesForType.dao;

import com.spring.namesForType.base.BaseRepository;
import com.spring.namesForType.entity.MemberEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

/**
 * 恨不能放一张微信二维码啊
 *
 * @author 钢牌讲师-子路 qq 244854192
 * @date 2021/3/3114:31
 */
@Component
public class MemberRepository extends BaseRepository<MemberEntity> {

	public void foo(){
		Type genericSuperclass = this.getClass().getGenericSuperclass();
	}
}
