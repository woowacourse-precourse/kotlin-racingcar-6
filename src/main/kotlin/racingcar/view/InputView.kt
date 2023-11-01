package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun submitCarNames() = println(SUBMIT_CAR_NAMES_MESSAGE)
    fun askTimes(): Int {
        println(ASK_TIMES_MESSAGE)
        val timesInput = Console.readLine().toInt()
        if (timesInput < 1) {
            throw IllegalArgumentException()
        }
        return timesInput
    }

    companion object {
        const val SUBMIT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ASK_TIMES_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}