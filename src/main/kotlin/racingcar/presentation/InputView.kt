package racingcar.presentation

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarLineUp(): String {
        println(ASK_CAR_NAME)
        val carLineUp = Console.readLine()
        require(carLineUp.isNotBlank()) { "[ERROR] 자동차 이름이 잘못 입력되었습니다. 값이 없어요." }
        return carLineUp
    }

    fun readRoundNumbers(): Int {
        println(ASK_ROUND_NUMBERS)
        val input = Console.readLine()
        require(input.isNotBlank()) { "[ERROR] 시도할 횟수가 잘못 입력되었습니다. 값이 없어요" }
        val roundNumbers = input.toIntOrNull()
        requireNotNull(roundNumbers) { "[ERROR] 시도할 횟수가 잘못 입력되었습니다. 숫자가 아닙니다." }
        return roundNumbers
    }

    companion object {
        private const val ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val ASK_ROUND_NUMBERS = "시도할 횟수는 몇 회인가요?"
    }
}