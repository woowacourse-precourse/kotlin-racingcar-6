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
            print("${Constants.STEP_SYMBOL}".repeat(i.getForwardCount()))
        }
    }

    fun printFinalWinner(carNameList: List<String>){
        print("${Constants.FINAL_WINNER_MESSAGE}")
        println(carNameList.joinToString(", "))
    }
}