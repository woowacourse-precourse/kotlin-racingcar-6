package racingcar.service

import racingcar.exception.InputException
import racingcar.model.Car

class RaceService {
	val carService = CarService()

	var raceNumber: Int = 0
	val locationExpression = "-"

	fun createRaceNumber(raceNumber: String) {
		this.raceNumber = InputException().validateAttemptNumber(raceNumber)
	}

	fun playRace() {
		for(i in 0..<raceNumber) {
			carService.moveCar()
			val cars = carService.getCarList()
			cars.forEach(fun(car: Car) {
				println(String.format("%s : %s", car.name, locationExpression.repeat(car.location)))
			})
			println()
		}
	}
}