package racingcar.domain

import racingcar.constant.ErrorMessage

class RacingCars(nameList: List<String>) {
    private val racingCars = mutableListOf<RacingCar>()

    init {
        validateNameLength(nameList)
        nameList.forEach {
            racingCars.add(RacingCar(it))
        }
    }

    fun loadRacingCars() = racingCars

    private fun validateNameLength(carNames: List<String>) {
        validateCarNamesLength(carNames)
    }

    private fun validateCarNamesLength(carNames: List<String>) {
        require(carNames.none { it.length > MAX_NAME_LENGTH }) { ErrorMessage.NAME_LENGTH_GREATER_THAN_FIVE }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}