package racingcar.views

import camp.nextstep.edu.missionutils.Console

class InputView {

    companion object {
        const val ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?"
    }

    fun inputView(): String = Console.readLine()

    fun gameStartMessage() {
        println(ASK_CAR_NAME)
    }

    fun inputTryCountMessage() {
        println(ASK_TRY_COUNT)
    }
}
