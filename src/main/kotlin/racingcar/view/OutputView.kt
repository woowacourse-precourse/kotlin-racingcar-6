package racingcar.view

import racingcar.model.Constants

class OutputView {
    fun carInputMassage() {
        println(Constants.CAR_NAME_WRITE)
    }

    fun tryInputMassage() {
        println(Constants.TRY_WRITE)
    }

    fun racingResult() {
        println(Constants.RESULT)
    }

    fun eachRacingResult(cars: List<String>, progress: List<String>) {
        for (index in 0..<cars.size) {
            println(cars[index] + Constants.COLON + progress[index])
        }
        println()
    }

    fun winner(winners: List<String>) {
        val result: String = winners.joinToString(Constants.COMMA.toString() + Constants.SPACE_BAR.toString())
        print(Constants.WINNER + Constants.COLON)
        println(result)
    }
}