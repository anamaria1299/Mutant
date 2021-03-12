package challenge.mutant.domain;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MutantValidatorTest {

	@Test(dataProvider = "mutant-dna")
	void shouldValidateMutant(String[] dna) {

		boolean isMutant = validateMutant(dna);
		assertTrue(isMutant);
	}

	@Test(dataProvider = "human-dna")
	void shouldValidateNotMutant(String[] dna) {

		boolean isMutant = validateMutant(dna);
		assertFalse(isMutant);
	}

	@DataProvider(name = "mutant-dna")
	public Object[][] dataProviderMutantDna() {
		return new Object[][] { { new String[] {"AAAA", "TCTA", "ATAC", "GGGG"} }, // horizontal
		                        { new String[] {"ATAG", "ACTG", "ATAG", "AACG"} }, // vertical
		                        { new String[] {"ATCGA", "TAAGG", "CTACC", "TGTAA", "ACTTG"} }, // validate right oblique
		                        { new String[] {"AGCTA", "GGAAT", "CCATC", "AATGT", "GTTCA"} }, // validate left oblique
		                        { new String[] {"AAAA", "ATCG", "ACGT", "ATTT"}}, // vertical - horizontal sharing one char
		                        { new String[] {"ATCA", "GATA", "CTAA", "GCTA"}}, // oblique - vertical sharing one char
		                        { new String[] {"ACAT", "TAGC", "CTAT", "AAAA"}}, // oblique - horizontal sharing one char
		                        { new String[] {"ACGTA", "CACAA", "GTACC", "GAGAT", "TCATG"}}, // oblique - oblique sharing one char
		                        { new String[] {"ACGTATT", "CTAGTAG", "CGTTTTA", "ACTCGAT", "ATCTGAA", "AGACGCT", "ATCGGGG"} }, // all directions
		};
	}

	@DataProvider(name = "human-dna")
	public Object[][] dataProviderHumanDna() {
		return new Object[][] { { new String[] {"AAA", "TCT", "ATA"} }, // length less than necessary
		                        { new String[] {"AAAA", "TACG", "CGTC", "GCAT"} }, // just one horizontal
		                        { new String[] {"ATCG", "AAGC", "ACTA", "AGCT"} }, // just one vertical
		                        { new String[] {"ACGA", "CATC", "GTAT", "ACGA"} }, // just one right oblique
		                        { new String[] {"CCTA", "TTAT", "GATG", "ACCC"} }, // just one left oblique
		                        { new String[] {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"} }};
	}

	private boolean validateMutant(String[] dna) {

		final MutantValidator mutantValidator = new MutantValidator();
		return mutantValidator.validateMutant(dna);
	}

}