package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.global.InformationMessage
import racingcar.service.CarService
import racingcar.service.RaceService

class GameController {
	var carService = CarService()
	var raceService = RaceService()

	fun start() {
		createCarList()
		createRaceNumber()
		println()
		playRace()
	}

	fun createCarList() {
		println(InformationMessage.INPUT_CARS_NAME.message)
		val input = Console.readLine().split(",")
		carService.createCarList(input)
	}

	fun createRaceNumber() {
		println(InformationMessage.ATTEMPT_NUMBER.message)
		val input = Console.readLine()
		raceService.createRaceNumber(input)
	}

	fun playRace() {
		println(InformationMessage.EXECUTION_RESULT.message)
		raceService.playRace()
	}
}