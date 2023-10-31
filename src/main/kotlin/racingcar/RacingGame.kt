package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame {
    private val exception = Exception()
    private val computer = Computer()

    fun gameStart() {
        printGameStartMessage()
        val cars = initCar()
        val roundCount = readRounds()
        computer.playGame(roundCount, cars)
        computer.printWinner(cars)
    }

    private fun initCar(): List<Car> {
        val name = readCarNames()
        exception.nameValidation(name)
        return name.map { Car(it) }
    }

    private fun readCarNames(): List<String> {
        val input = Console.readLine()
        return input.split(",")
    }

    private fun readRounds(): Int {
        printRoundMessage()
        val input = Console.readLine()
        return exception.roundsValidation(input)
    }

    private fun printGameStartMessage() = println(GAME_START_MESSAGE)
    private fun printRoundMessage() = println(ROUND_MESSAGE)

    companion object {
        const val GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}