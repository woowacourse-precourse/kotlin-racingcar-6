package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Util.separateNameByComma
import racingcar.util.Validator.validateInteger
import racingcar.util.Validator.validateLength
import racingcar.util.Validator.validateNotNull
import racingcar.util.Validator.validateRange
import racingcar.util.Validator.validateUnique

class InputView {
    fun getUserInput(): String = Console.readLine()

    fun getInputCarNames(): List<String> {
        val input = separateNameByComma(getUserInput())
        validateLength(input)
        validateUnique(input)
        validateNotNull(input)
        return input
    }

    fun getInputCount(): Int {
        val input = getUserInput()
        validateInteger(input)
        validateRange(input)
        return input.toInt()
    }
}