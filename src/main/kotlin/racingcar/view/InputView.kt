package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constant.Constants.ATTEMPTS_PROMPT
import racingcar.constant.Constants.CAR_NAME_PROMPT

class InputView {
    fun getCarName(): ArrayList<String> {
        println(CAR_NAME_PROMPT)
        return ArrayList(Console.readLine().split(","))
    }

    fun getNumberOfAttemps(): String {
        println(ATTEMPTS_PROMPT)
        return Console.readLine()
    }
}
