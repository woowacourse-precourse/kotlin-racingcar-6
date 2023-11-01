package view

import constants.Strings
import model.Car
import model.CarList

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

    fun outputWinners(carList: CarList) {
        val winnerList: String = carList.findWinnerList(carList)
        println(Strings.WINNER_LIST + winnerList)
    }

    fun outputBlankLine() {
        println()
    }
}