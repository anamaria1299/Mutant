package challenge.mutant.services;

import challenge.mutant.domain.MutantValidator;
import challenge.mutant.repository.MutantRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService {

	public final MutantRepository mutantRepository;

	public MutantServiceImpl(MutantRepository mutantRepository) {

		this.mutantRepository = mutantRepository;
	}

	@Override
	@Cacheable(cacheNames = "mutantService")
	public boolean isMutant(String[] dna) {

		MutantValidator mutantValidator = new MutantValidator();
		final boolean isMutant = mutantValidator.validateMutant(dna);
		String dnaString = String.join("", dna);

		mutantRepository.saveDna(dnaString, isMutant);

		return isMutant;
	}
}
