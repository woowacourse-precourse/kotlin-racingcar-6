package racingcar.domain

import racingcar.constant.ErrorMessage

class RacingCars(nameList: List<String>) {
    private val racingCars = mutableListOf<RacingCar>()

    init {
        validateNameListSize(nameList)
        validateNameLength(nameList)
        nameList.forEach {
            racingCars.add(RacingCar(it))
        }
    }

    fun loadRacingCars() = racingCars

    private fun validateNameListSize(nameList: List<String>) {
        require(nameList.size >= MIN_RACING_CAR_COUNT) { ErrorMessage.RACING_CAR_LESS_THAN_TWO.message }
    }

    private fun validateNameLength(carNames: List<String>) {
        validateCarNamesLength(carNames)
    }

    private fun validateCarNamesLength(carNames: List<String>) {
        require(carNames.none { it.length > MAX_NAME_LENGTH }) { ErrorMessage.NAME_LENGTH_GREATER_THAN_FIVE }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_RACING_CAR_COUNT = 2
    }
}