package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.global.InformationMessage
import racingcar.service.CarService

class GameController {
	var carService = CarService()

	fun start() {
		createCarList()
	}

	fun createCarList() {
		println(InformationMessage.INPUT_CARS_NAME.message)
		val input = Console.readLine().split(",")
		carService.createCarList(input)
	}
}