package challenge.mutant.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stat implements Serializable {

	@JsonProperty("count_mutant_dna")
	private Long countMutantDna;

	@JsonProperty("count_human_dna")
	private Long countHumanDna;

	private double ration;

	public Stat() { }

	public Stat(Long countMutantDna, Long countHumanDna, double ration) {

		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
		this.ration = ration;
	}

	public Long getCountMutantDna() {

		return countMutantDna;
	}

	public Long getCountHumanDna() {

		return countHumanDna;
	}

	public double getRation() {

		return ration;
	}

}
