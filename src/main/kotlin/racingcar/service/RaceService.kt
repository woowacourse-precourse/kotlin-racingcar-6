package racingcar.service

import racingcar.exception.InputException

class RaceService {
	var raceNumber: Int = 0

	fun createRaceNumber(raceNumber: String) {
		this.raceNumber = InputException().validateAttemptNumber(raceNumber)
	}
}