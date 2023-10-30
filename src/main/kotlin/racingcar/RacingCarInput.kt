package racingcar

import racingcar.ErrorMessage.CAR_MINIMUM_COUNT_ERROR
import racingcar.ErrorMessage.DUPLICATE_CAR_NAME_ERROR

object RacingCarInput {
    private const val MIN_CAR_COUNT = 1

    private fun validateCarNameDuplicate(carNameMap: Map<String, Int>) {
        val carNames = carNameMap.keys
        if (carNames.size != carNames.distinct().size) {
            throw IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR)
        }
    }

    private fun validateMinimumCarCount(carNameMap: Map<String, Int>) {
        if (carNameMap.size <= MIN_CAR_COUNT) {
            throw IllegalArgumentException(CAR_MINIMUM_COUNT_ERROR)
        }
    }
}
