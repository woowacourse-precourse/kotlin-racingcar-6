package racingcar.views

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputView(): String = Console.readLine()

    fun gameStartMessage() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun inputTryCountMessage() {
        println("시도할 횟수는 몇 회인가요?")
    }
}
