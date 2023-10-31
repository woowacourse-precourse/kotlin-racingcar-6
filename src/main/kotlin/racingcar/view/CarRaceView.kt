package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Constants.WINNER
import racingcar.util.Validation.validateName
import racingcar.util.Validation.validateNum

class CarRaceView {

    fun inputCarName(): List<String> {
        val cars = Console.readLine().split(",").toList()

        validateName(cars)
        return cars
    }

    fun inputAttemptNumber(): String {
        val attemptNum = Console.readLine()

        validateNum(attemptNum)
        return attemptNum
    }

    fun outputWinner(winner: String) {
        println(WINNER + winner)
    }

    fun outputCarsPosition(position: Int) {
        val sb = StringBuilder()
        repeat(position) {
            sb.append("-")
        }
        println(sb.toString())
    }


}