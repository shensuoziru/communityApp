package ca.bytetube.communityApp.service.impl;

import ca.bytetube.communityApp.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CacheServiceImpl implements CacheService {
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public void removeFromCache(String keyPrefix) {
		Set<String> keySet = redisTemplate.keys(keyPrefix + "*");
		for (String key : keySet) {
			redisTemplate.delete(key);
		}
	}

}
