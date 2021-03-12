package challenge.mutant.services;

import challenge.mutant.repository.MutantRepository;
import challenge.mutant.domain.Stat;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

	private final MutantRepository mutantRepository;

	public StatsServiceImpl(MutantRepository mutantRepository) {

		this.mutantRepository = mutantRepository;
	}

	@Override
	public Stat getStats() {

		final Long countMutantDna = mutantRepository.getNumberOfMutants();
		final Long countHumanDna = mutantRepository.getNumberOfHumans();
		final double ration = calculateRation(countMutantDna, countHumanDna);

		return new Stat(countMutantDna, countHumanDna, ration);
	}

	private double calculateRation(final Long countMutantDna, final Long countHumanDna) {

		if(countHumanDna == 0) {
			return 0;
		}

		return (double) countMutantDna/ (double) countHumanDna;
	}
}
