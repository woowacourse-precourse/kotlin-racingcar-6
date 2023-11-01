package view

import constants.Strings
import model.Car

class OutputView {
    fun outputCarList() {
        println(Strings.INPUT_CAR_NAME)
    }

    fun outputTryNum() {
        println(Strings.INPUT_TRY_NUM)
    }

    fun outputTryResult() {
        println("\n" + Strings.TURN_RESULT)
    }

    fun outputTurnResult(car: Car) {
        val positionResult: String = "-".repeat(car.position)
        println("${car.name} : $positionResult")
    }
}