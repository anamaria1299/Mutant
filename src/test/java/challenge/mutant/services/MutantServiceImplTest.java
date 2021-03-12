package challenge.mutant.services;

import static org.mockito.Mockito.mock;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import challenge.mutant.repository.MutantRepository;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MutantServiceImplTest {

	private MutantRepository mutantRepository;

	private MutantService mutantService;

	@BeforeTest
	public void setUp() {

		mutantRepository = mock(MutantRepository.class);
		mutantService = new MutantServiceImpl(mutantRepository);
	}

	@Test
	void shouldBeMutantDna() {

		final boolean isMutant = mutantService.isMutant(new String[] {"AAAA", "TCTA", "ATAC", "GGGG"});
		assertTrue(isMutant);
	}

	@Test
	void shouldBeNotMutantDna() {

		final boolean isMutant = mutantService.isMutant(new String[] {"AAAA", "TACG", "CGTC", "GCAT"});
		assertFalse(isMutant);
	}
}