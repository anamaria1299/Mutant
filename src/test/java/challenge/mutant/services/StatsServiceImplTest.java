package challenge.mutant.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

import challenge.mutant.domain.Stat;
import challenge.mutant.repository.MutantRepository;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StatsServiceImplTest {

	private MutantRepository mutantRepository;

	private StatsService statsService;

	@BeforeTest
	public void setUp(){

		mutantRepository = mock(MutantRepository.class);
		statsService = new StatsServiceImpl(mutantRepository);
	}

	@Test
	void shouldGetStats() {

		when(mutantRepository.getNumberOfHumans()).thenReturn(100L);
		when(mutantRepository.getNumberOfMutants()).thenReturn(40L);

		final Stat stat = statsService.getStats();

		assertEquals(0.4, stat.getRation());
		assertEquals(100, stat.getCountHumanDna(), 0);
		assertEquals(40, stat.getCountMutantDna(), 0);
	}

	@Test
	void rationShouldBeZeroIfHumansNumberIsZero() {

		when(mutantRepository.getNumberOfHumans()).thenReturn(0L);
		when(mutantRepository.getNumberOfMutants()).thenReturn(100L);

		final Stat stat = statsService.getStats();

		assertEquals(0.0, stat.getRation());
		assertEquals(0, stat.getCountHumanDna(), 0);
		assertEquals(100, stat.getCountMutantDna(), 0);
	}

}