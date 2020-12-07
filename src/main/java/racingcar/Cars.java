package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;
	private final NumberGenerator numberGenerator;

	public Cars(List<String> carNames, NumberGenerator numberGenerator) {
		this.cars = carNames.stream()
			.map(name -> new Car(name))
			.collect(Collectors.toList());

		this.numberGenerator = numberGenerator;
	}

	public void move() {
		for (Car car : this.cars) {
			car.tryMove(numberGenerator.createNumber());
		}
	}

	public RacingResults racingResults() {
		List<RacingResult> results = cars.stream()
			.map(car -> new RacingResult(car.getName(), car.getMoveCount()))
			.collect(Collectors.toList());
		return new RacingResults(results);
	}

	public int sizeOfCars() {
		return this.cars.size();
	}
}
