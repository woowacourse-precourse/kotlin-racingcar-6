package racingcar

import camp.nextstep.edu.missionutils.Console

class User {
    fun requestInputCarNames(): List<Car> {
        val input = Console.readLine()

        return createCars(input)
    }

    fun createCars(input: String): List<Car> {
        Validator.validateInput(input)

        val carNames = input.split(NAME_SEPARATOR).map { it.trim() }
        carNames.forEach { Validator.validateCarName(it) }

        return carNames.map { Car(it) }
    }
}