package challenge.mutant.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MutantRedisRepository implements MutantRepository{

	private final RedisTemplate<String, String> redisTemplate;

	private static final String MUTANT_KEY = "mutant";

	private static final String HUMAN_KEY = "human";

	public MutantRedisRepository(RedisTemplate<String, String> redisTemplate) {

		this.redisTemplate = redisTemplate;
	}

	@Override
	public void saveDna(String dna, boolean isMutant) {

		if(isMutant) {
			redisTemplate.opsForHash().put(MUTANT_KEY, dna, "");
		} else {
			redisTemplate.opsForHash().put(HUMAN_KEY, dna, "");
		}

	}

	@Override
	public Long getNumberOfMutants() {

		return redisTemplate.opsForHash().size(MUTANT_KEY);
	}

	@Override
	public Long getNumberOfHumans() {

		return redisTemplate.opsForHash().size(HUMAN_KEY);
	}
}
