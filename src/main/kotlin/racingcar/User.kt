package racingcar

import camp.nextstep.edu.missionutils.Console

class User {
    fun requestInputCarNames(): List<Car> {
        val input = Console.readLine()
        Validator.validateInput(input)

        return createCars(input)
    }

    fun createCars(input: String): List<Car> {
        val carNames = input.split(NAME_SEPARATOR).map { it.trim() }
        carNames.forEach { Validator.validateCarName(it) }

        return carNames.map { Car(it) }
    }

    fun requestInputMoveCount(): Int {
        val input = Console.readLine()
        Validator.validateInput(input)

        return parseInputToMoveCount(input)
    }

    private fun parseInputToMoveCount(input: String): Int {
        Validator.validateMoveCountInput(input)

        return input.toInt()
    }
}