package challenge.mutant.controllers;

import challenge.mutant.domain.Stat;
import challenge.mutant.services.StatsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatController {

	private final StatsService statsService;

	public StatController(StatsService statsService) {

		this.statsService = statsService;
	}

	@GetMapping
	public ResponseEntity<Stat> getStats() {

		Stat statResponse = statsService.getStats();
		return new ResponseEntity<>(statResponse, HttpStatus.OK);
	}
}
