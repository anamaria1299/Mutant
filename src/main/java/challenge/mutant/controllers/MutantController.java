package challenge.mutant.controllers;

import challenge.mutant.domain.Dna;
import challenge.mutant.services.MutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/mutant/")
public class MutantController {

	private final MutantService mutantService;

	public MutantController(MutantService mutantService) {

		this.mutantService = mutantService;
	}

	@PostMapping
	public ResponseEntity<Dna> isMutant(@RequestBody Dna dna) {

		HttpStatus responseStatus = mutantService.isMutant(dna.getDna()) ?
		                            HttpStatus.OK : HttpStatus.FORBIDDEN;
		return new ResponseEntity<>(dna, responseStatus);
	}
}
