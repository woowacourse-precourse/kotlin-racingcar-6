package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.exception.InputException
import racingcar.model.Car

class CarService {
	companion object {
		lateinit var cars: List<Car>
	}

	fun createCarList(carNames: List<String>) {
		InputException().validateCarName(carNames)
		Companion.cars = carNames.map { Car(it, 0) }
	}

	fun getCarList(): List<Car> {
		return Companion.cars
	}

	fun moveCar() {
		Companion.cars.forEach { car ->
			val random = Randoms.pickNumberInRange(0, 9)
			if(random >= 4) car.move()
		}
	}
}