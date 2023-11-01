package racingcar.ui

import camp.nextstep.edu.missionutils.Console

class Player {
    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return inputWithNullCheck().split(",")
    }

    fun inputTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = inputIntWithNullCheck()
        if (tryCount < 1) {
            throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
        }
        return tryCount
    }

    private fun inputWithNullCheck() = Console.readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")

    private fun inputIntWithNullCheck() =
        inputWithNullCheck().toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
}
