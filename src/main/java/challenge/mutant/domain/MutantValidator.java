package challenge.mutant.domain;

public class MutantValidator {

	private int numberOfMutantStrings = 0;

	private static  final int NECESSARY_STRINGS_TO_BE_MUTANT = 2;

	private static final int NECESSARY_LENGTH_TO_BE_MUTANT_STRING = 4;

	public boolean validateMutant(String[] dna) {

		if(dna.length < NECESSARY_LENGTH_TO_BE_MUTANT_STRING) {
			return false;
		}

		validateHorizontal(dna);
		validateVertical(dna);
		validateRightOblique(dna);
		validateLeftOblique(dna);

		return isMutant();
	}

	private void validateHorizontal(final String[] dna) {

		int index = 0;

		while(shouldContinueWithValidation(!isMutant(), index < dna.length)) {
			StringBuilder row = new StringBuilder();
			for (int j = 0; j < dna.length; j++) {
				row.append(dna[index].charAt(j));
			}
			validateString(row.toString());
			index++;
		}
	}

	private void validateVertical(final String[] dna) {

		int index = 0;

		while(shouldContinueWithValidation(!isMutant(), index < dna.length)) {
			StringBuilder row = new StringBuilder();
			for (int j = 0; j < dna.length; j++) {
				row.append(dna[j].charAt(index));
			}
			validateString(row.toString());
			index++;
		}
	}

	private void validateRightOblique(final String[] dna) {

		validateRightUpOblique(dna);
		validateRightDownOblique(dna);
	}

	private void validateLeftOblique(final String[] dna) {

		validateLeftUpOblique(dna);
		validateLeftDownOblique(dna);
	}

	private void validateRightUpOblique(String[] dna) {

		int index = 0;

		while(shouldContinueWithValidation(!isMutant(), index < dna.length)) {

			String stringToValidate = getObliqueString(dna, 0, index);
			validateString(stringToValidate);
			index++;
		}
	}

	private void validateRightDownOblique(String[] dna) {

		int index = 1;

		while(shouldContinueWithValidation(!isMutant(), index < dna.length)) {
			String stringToValidate = getObliqueString(dna, index, 0);
			validateString(stringToValidate);
			index++;
		}
	}

	private void validateLeftDownOblique(String[] dna) {

		int index = 1;

		while(shouldContinueWithValidation(!isMutant(), index < dna.length)) {

			int startColumn = dna.length - 1;
			int startRow = index;
			StringBuilder stringToValidate = new StringBuilder();
			while(startRow < dna.length && startColumn < dna.length) {
				stringToValidate.append(dna[startRow].charAt(startColumn));
				startRow++;
				startColumn--;
			}
			validateString(stringToValidate.toString());
			index++;
		}
	}

	private void validateLeftUpOblique(String[] dna) {

		int index = 0;

		while(shouldContinueWithValidation(!isMutant(), index < dna.length)) {

			int startColumn = index;
			int startRow = 0;
			StringBuilder stringToValidate = new StringBuilder();
			while(startRow >= 0 && startColumn >= 0) {
				stringToValidate.append(dna[startRow].charAt(startColumn));
				startRow++;
				startColumn--;
			}
			validateString(stringToValidate.toString());
			index++;
		}
	}

	private String getObliqueString(final String[] dna, int startRow, int startColumn) {

		StringBuilder stringToValidate = new StringBuilder();
		while (startRow < dna.length  && startColumn < dna.length) {
			stringToValidate.append(dna[startRow].charAt(startColumn));
			startRow++;
			startColumn++;
		}
		return stringToValidate.toString();
	}

	private void validateString(final String stringToValidate) {

		int similars = 0;
		char before = stringToValidate.charAt(0);

		for (int i = 0; i < stringToValidate.length(); i++) {

			similars = before == stringToValidate.charAt(i) ? similars + 1 : 0;
			if(similars == NECESSARY_LENGTH_TO_BE_MUTANT_STRING) {
				numberOfMutantStrings += 1;
				similars = 0;
			}
		}
	}

	private boolean isMutant() {

		return numberOfMutantStrings >= NECESSARY_STRINGS_TO_BE_MUTANT;
	}

	private boolean shouldContinueWithValidation(final boolean isNotMutant, final boolean isInRange) {

		return isNotMutant && isInRange;
	}
}
