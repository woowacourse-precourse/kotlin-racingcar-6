package racingcar.view

import racingcar.view.Constant.INPUT_RACINGCAR_NAME_MASSAGE
import racingcar.view.Constant.RESULT_MESSAGE
import racingcar.view.Constant.TRY_NUMBER_MESSAGE

class OutputView {
    fun printInputRacingcarName() = println(INPUT_RACINGCAR_NAME_MASSAGE)

    fun printTryNumber() = println(TRY_NUMBER_MESSAGE)

    fun printResult() = println("\n$RESULT_MESSAGE")

    fun printCarScore(carScore: MutableMap<String, Int>) {
        carScore.forEach{(name, score) ->
            print("$name : ")
            for (i in 0 until score) {
                print("-")
            }
            print("\n")
        }
        print("\n")
    }
}

object Constant {
    const val INPUT_RACINGCAR_NAME_MASSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val TRY_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
    const val RESULT_MESSAGE = "실행 결과"
}