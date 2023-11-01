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
}