package racingcar.ui

import camp.nextstep.edu.missionutils.Console

const val MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val MSG_INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?"

object UserInput {
    fun readCarName(): String {
        println(MSG_INPUT_CAR_NAME)
        return Console.readLine()
    }
}

object UserOutput {

}