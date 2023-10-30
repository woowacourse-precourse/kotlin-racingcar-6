package racingcar.utils

import racingcar.game.Car

object Validator {

    private const val MIN_CAR_NAME_LENGTH = 1
    private const val MAX_CAR_NAME_LENGTH = 5

    private const val ERROR_CAR_NAME_EMPTY = "자동차의 이름 중 비어있는 이름이 있습니다."
    private const val ERROR_CAR_NAME_LENGTH = "자동차의 이름은 1자 이상, 5자 이하의 길이로 입력할 수 있습니다. %s"
    private const val ERROR_CAR_NAME_DUPLICATE = "중복된 이름이 있습니다. %s"
    private const val ERROR_CAR_NAME_BLANK = "이름에 공백이 포함돼서는 안됩니다. %s"
    private const val ERROR_ROUND_COUNT_HAVE_TO_OVER_1 = "시도할 횟수는 최소 1회 이상 숫자만 입력 가능합니다."

    fun validateInputCarNames(inputCarNames: List<Car>) {
        checkCarNamesNull(inputCarNames)
        checkCarNamesLength(inputCarNames)
        checkCarNamesDuplicate(inputCarNames)
        checkCarNamesContainBlank(inputCarNames)
    }

    fun validateInputRoundCount(inputRoundCount: Int) {
        if (inputRoundCount < 1) throw IllegalArgumentException(ERROR_ROUND_COUNT_HAVE_TO_OVER_1)
    }

    private fun checkCarNamesNull(carNames: List<Car>) {
        carNames.forEach {
            if (it.name.isBlank()) throw IllegalArgumentException(ERROR_CAR_NAME_EMPTY)
        }
    }

    private fun checkCarNamesLength(carNames: List<Car>) {
        carNames.forEach {
            if (it.name.length < MIN_CAR_NAME_LENGTH || it.name.length > MAX_CAR_NAME_LENGTH)
                throw IllegalArgumentException(ERROR_CAR_NAME_LENGTH.format(it))
        }
    }

    private fun checkCarNamesDuplicate(carNames: List<Car>) {
        val duplicatedCarNames = carNames.groupingBy { it.name }.eachCount().filter { it.value > 1 }.keys.toList()
        if (duplicatedCarNames.isNotEmpty())
            throw IllegalArgumentException(ERROR_CAR_NAME_DUPLICATE.format(duplicatedCarNames))
    }

    private fun checkCarNamesContainBlank(carNames: List<Car>) {
        val blankContainedCarNames = carNames.filter { it.name.contains(" ") }
        if (blankContainedCarNames.isNotEmpty())
            throw IllegalArgumentException(ERROR_CAR_NAME_BLANK.format(blankContainedCarNames))
    }
}