package racingcar.ui

import camp.nextstep.edu.missionutils.Console

const val MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val MSG_INPUT_ATTEMPT_COUNTS = "시도할 횟수는 몇 회인가요?"

object UserInput {
    fun readCarName(): String {
        println(MSG_INPUT_CAR_NAME)
        return Console.readLine()
            .trim()
    }

    /**
     * 입력을 콤마로 구분하여 자동차 이름 리스트를 생성한다.
     * 각 원소 앞 뒤 공백은 제거한다.
     */
    fun String.createNameList(): List<String> {
        return this.split(',')
            .map { it.trim() }
    }

    fun readAttemptCounts(): String {
        println(MSG_INPUT_ATTEMPT_COUNTS)
        return Console.readLine()
    }
}

object UserOutput {

}