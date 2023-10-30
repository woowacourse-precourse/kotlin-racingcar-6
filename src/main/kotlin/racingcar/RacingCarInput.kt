package racingcar

import racingcar.ErrorMessage.DUPLICATE_CAR_NAME_ERROR

object RacingCarInput {

    private fun validateCarNameDuplicate(carNameMap: Map<String, Int>) {
        val carNames = carNameMap.keys
        if (carNames.size != carNames.distinct().size) {
            throw IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR)
        }
    }
}
