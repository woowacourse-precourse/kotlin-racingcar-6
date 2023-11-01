package racingcar.exception

class InputException {
	fun validateCarName(cars: List<String>) {
		for(car in cars) {
			require(car.length <= 5) {ErrorCode.CHARACTERS_NUMBER_EXCEEDED.message}
		}
	}
}