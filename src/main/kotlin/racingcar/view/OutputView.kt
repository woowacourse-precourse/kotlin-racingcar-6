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

    fun eachRacingResult(cars: List<String>, progress: List<Int>) {
        for (index in 0..cars.size - 1) {
            print(cars[index] + Constants.COLON)
            dashPrint(progress[index])
        }
        println()
    }

    fun dashPrint(progress: Int) {
        if (progress != 0) {
            for (index in 1..progress) {
                print(Constants.DASH)
            }
        }
        println()
    }

    fun winner(winners:List<String>) {
        val result = winners.joinToString { ", " }
        println(result)
    }
}