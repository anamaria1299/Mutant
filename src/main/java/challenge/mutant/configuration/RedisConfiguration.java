package challenge.mutant.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {


	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {

		final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

		RedisTemplate<String, String> redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(stringRedisSerializer);
		redisTemplate.setValueSerializer(stringRedisSerializer);

		return redisTemplate;
	}
}
