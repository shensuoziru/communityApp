package ca.bytetube.communityApp.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * spring-redis.xml里的配置
 */
@Configuration
public class RedisConfiguration {
    @Value("${redis.hostname}")
    private String redisHostname;

    @Value("${redis.port}")
    private int redisPort;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 配置连接池的属性
        // ...
        return poolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(redisHostname);
        connectionFactory.setPort(redisPort);
        return connectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
