package racingcar.ui

import camp.nextstep.edu.missionutils.Console

const val MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val MSG_INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?"
const val MSG_OUTPUT_RESULT = "실행 결과"
const val MSG_OUTPUT_WINNER = "최종 우승자 : "

object UserInput {

    fun readCarName(): String {
        println(MSG_INPUT_CAR_NAME)
        return Console.readLine()
            .trim()
    }

    fun String.createNameList(): List<String> {
        return this.split(',')
            .map { it.trim() }
    }

    fun readAttemptCount(): String {
        println(MSG_INPUT_ATTEMPT_COUNT)
        return Console.readLine()
            .trim()
    }
}

object UserOutput {

    fun printResultMessage() = println(MSG_OUTPUT_RESULT)
    fun displayRoundResult(name: String, path: String) = print("$name : $path\n")

    fun printWinner(winner: List<String>) {
        print(MSG_OUTPUT_WINNER)
        println(winner.joinToString(", "))
    }
}