package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Constants.WINNER

class CarRaceView {

    fun inputCarName(): List<String> {
        val cars = Console.readLine().split(",").toList()

        return cars
    }

    fun inputAttemptNumber() : String {
        val num = Console.readLine()

        return num
    }

    fun outputWinner(winner : String) {
        println(WINNER + winner)
    }



}