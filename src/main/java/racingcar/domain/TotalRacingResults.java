package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TotalRacingResults {
	private final List<RacingResults> totalResults;

	public TotalRacingResults(List<RacingResults> totalResults) {
		this.totalResults = Optional.ofNullable(totalResults)
			.orElse(Collections.emptyList());
	}

	public List<String> winners() {
		if (this.totalResults.size() == 0) {
			return new ArrayList<>();
		}
		return finalResult().winners();
	}

	private RacingResults finalResult() {
		return this.totalResults.get(this.totalResults.size() - 1);
	}

	public List<RacingResults> getTotalResults() {
		return totalResults;
	}
}
