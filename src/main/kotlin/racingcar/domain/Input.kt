package racingcar.domain

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Validation.checkContainComma
import racingcar.domain.Validation.checkNameLength

class Input {

    fun carName(): List<String> {
        println(NAME_GUIDE_MESSAGE)
        val userInput = Console.readLine()
        checkContainComma(userInput)

        val carNameList = userInput.split(",")
        checkNameLength(carNameList)

        return carNameList
    }

    fun attemptNum(): Int {
        println(ATTEMPT_NUM_MESSAGE)
        try {
            return Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw java.lang.IllegalArgumentException(ATTEMPT_ERROR_MESSAGE)
        }
    }

    companion object {
        private const val NAME_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val ATTEMPT_NUM_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val ATTEMPT_ERROR_MESSAGE = "숫자만 입력해주세요"
    }

}