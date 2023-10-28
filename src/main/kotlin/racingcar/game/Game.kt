package racingcar.game

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Constants.CAR_NAME_DELIMITER
import racingcar.util.Constants.TEXT_START_GAME

class Game {

    private var carList = mutableListOf<String>()

    fun startGame() {
        println(TEXT_START_GAME)

        val input = Console.readLine()
        carList = inputCarName(input)
    }

    fun inputCarName(input: String) : MutableList<String> {
        val splitResult = mutableListOf<String>()

        input.split(CAR_NAME_DELIMITER).forEach {
            splitResult.add(it)
        }

        return splitResult
    }
}