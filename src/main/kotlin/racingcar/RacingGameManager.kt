package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.data.Car

class RacingGameManager {

    fun run() {
        printGameStart()
        createCars()

        closeConsole()
    }

    private fun printGameStart() = println(Message.INPUT_CAR_NAME.message)

    private fun createCars(): List<Car> {
        val cars = mutableListOf<Car>()
        val carNameFromUser = inputDataFromUser()

        return cars
    }

    private fun inputDataFromUser(): String = Console.readLine()

    private fun closeConsole() = Console.close()
}