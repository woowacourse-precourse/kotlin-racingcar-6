package racingcar.view

import racingcar.model.Car
import racingcar.utils.Constants
import racingcar.utils.inputHandler

class RacingCarView {
    fun getUserInputForCarName(): String {
        println(Constants.GAME_START_MESSAGE)
        return inputHandler()
    }

    fun getUserInputForForwardCount(): String {
        println(Constants.ATTEMPT_COUNT_QUESTION)
        return inputHandler()
    }

    fun printResultMessage() {
        println(Constants.RESULT_MESSAGE)
    }

    fun printGameResult(carList: List<Car>) {
        for (i in carList) {
            print("${i.getCarName()} : ")
            println("${Constants.STEP_SYMBOL}".repeat(i.getForwardCount()))
        }
    }

    fun printFinalWinner(carList: List<Car>) {
        print("${Constants.FINAL_WINNER_MESSAGE}")
        
        var carNameList = mutableListOf<String>()
        carList.map { carNameList.add(it.getCarName()) }
        println(carNameList.joinToString(", "))
    }
}