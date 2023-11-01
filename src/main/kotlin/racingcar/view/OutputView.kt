package racingcar.view

import racingcar.util.COLON
import racingcar.util.DASH
import racingcar.util.RESULT_MESSAGE

class OutputView {
    fun progressResult() {
        println(RESULT_MESSAGE)
    }

    fun roundResult(car: String) {
        print(car + COLON)
    }

    fun makeDash(progress: Int) {
        repeat(progress) {
            print(DASH)
        }
        println()
    }
}