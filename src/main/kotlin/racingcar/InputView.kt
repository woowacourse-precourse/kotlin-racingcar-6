package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {

    private const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val MIN_CAR_NAME_LENGTH = 1
    private const val MAX_CAR_NAME_LENGTH = 5

    private const val ERROR_CAR_NAME_EMPTY = "자동차의 이름 중 비어있는 이름이 있습니다."
    private const val ERROR_CAR_NAME_LENGTH = "자동차의 이름은 1자 이상, 5자 이하의 길이로 입력할 수 있습니다. %s"
    private const val ERROR_CAR_NAME_DUPLICATE = "중복된 이름이 있습니다. %s"
    private const val ERROR_CAR_NAME_BLANK = "이름에 공백이 포함돼서는 안됩니다. %s"

    fun inputCarNames(): List<String> {
        println(INPUT_CAR_NAMES)
        val inputCarNames = stringToList(Console.readLine())
        validateInputCarNames(inputCarNames)
        return inputCarNames
    }

    fun stringToList(input: String): List<String> = input.split(",").map { it.trim() }

    fun validateInputCarNames(inputCarNames: List<String>) {
        checkCarNamesNull(inputCarNames)
        checkCarNamesLength(inputCarNames)
        checkCarNamesDuplicate(inputCarNames)
        checkCarNamesContainBlank(inputCarNames)
    }

    private fun checkCarNamesNull(carNames: List<String>) {
        carNames.forEach {
            if (it.isBlank()) throw IllegalArgumentException(ERROR_CAR_NAME_EMPTY)
        }
    }

    private fun checkCarNamesLength(carNames: List<String>) {
        carNames.forEach {
            if (it.length < MIN_CAR_NAME_LENGTH || it.length > MAX_CAR_NAME_LENGTH)
                throw IllegalArgumentException(ERROR_CAR_NAME_LENGTH.format(it))
        }
    }

    private fun checkCarNamesDuplicate(carNames: List<String>) {
        val duplicatedCarNames = carNames.groupingBy { it }.eachCount().filter { it.value > 1 }.keys.toList()
        if (duplicatedCarNames.isNotEmpty())
            throw IllegalArgumentException(ERROR_CAR_NAME_DUPLICATE.format(duplicatedCarNames))
    }

    private fun checkCarNamesContainBlank(carNames: List<String>) {
        val blankContainedCarNames = carNames.filter { it.contains(" ") }
        if (blankContainedCarNames.isNotEmpty())
            throw IllegalArgumentException(ERROR_CAR_NAME_BLANK.format(blankContainedCarNames))
    }
}