package challenge.mutant.domain;

import java.io.Serializable;

public class Dna implements Serializable {

	private String[] dna;

	public Dna() { }

	public Dna(String[] dna) {

		this.dna = dna;
	}

	public String[] getDna() {

		return dna;
	}
}
