package challenge.mutant.controllers;

import static org.mockito.Mockito.mock;
import static org.testng.AssertJUnit.assertEquals;

import challenge.mutant.domain.Dna;
import challenge.mutant.repository.MutantRepository;
import challenge.mutant.services.MutantService;
import challenge.mutant.services.MutantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MutantControllerTest {

	private MutantRepository mutantRepository;

	private MutantService mutantService;

	private MutantController mutantController;

	@BeforeTest
	public void setUp() {

		mutantRepository = mock(MutantRepository.class);
		mutantService = new MutantServiceImpl(mutantRepository);
		mutantController = new MutantController(mutantService);
	}

	@Test
	void shouldResponseWithOKWhenIsMutant() {

		final Dna dna = new Dna(new String[] {"AAAA", "TCTA", "ATAC", "GGGG"});
		final ResponseEntity<Dna> responseEntity = mutantController.isMutant(dna);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	void shouldResponseWithForbiddenWhenIsNotMutant() {

		final Dna dna = new Dna(new String[] {"AAA", "TCT", "ATA"});
		final ResponseEntity<Dna> responseEntity = mutantController.isMutant(dna);

		assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
	}
}