package challenge.mutant.repository;

public interface MutantRepository {

	void saveDna(String dna, boolean isMutant);

	Long getNumberOfMutants();

	Long getNumberOfHumans();

}
