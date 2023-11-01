package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Constants.START_MESSAGE
import racingcar.utils.Constants.TRIAL_MESSAGE
import racingcar.utils.Validations

object InputView {
    fun inputCarName(): String {
        val name = Console.readLine()
        return Validations.inputCarName(name)
    }

    fun inputTrial(): Int {
        val num = Console.readLine()
        println()
        return Validations.inputTrial(num)
    }
}