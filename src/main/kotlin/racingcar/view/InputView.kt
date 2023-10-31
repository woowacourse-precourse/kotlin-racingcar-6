package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.controller.RacingCarController
import racingcar.model.RacingCar

class InputView {
    fun printInputCarName(): List<RacingCar> {
        println(INPUT_CAR_NAME_MESSAGE)
        val users = Console.readLine().split(NAME_DELIMITERS)
        checkSize(users)
        return users.map { RacingCar(it, INIT_DISTANCE_NUM) }
    }

    fun printInputGameCount(): Int {
        println(INPUT_GAME_COUNT_MESSAGE)
        val gameCount = Console.readLine()
        checkNumber(gameCount)
        return gameCount.toInt()
    }

    private fun checkSize(users: List<String>) {
        users.forEach {
            require(it.length <= RacingCarController.MAX_NAME_LENGTH_NUM)
        }
    }

    private fun checkNumber(input: String) {
        require(input.toIntOrNull() != null)
    }

    companion object {
        const val NAME_DELIMITERS = ","
        const val INIT_DISTANCE_NUM = 0
        const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_GAME_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}