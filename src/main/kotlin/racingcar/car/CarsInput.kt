package racingcar.car

import camp.nextstep.edu.missionutils.Console

class CarsInput {
    fun result(): List<Car> {
        return inputCarNames().map { Car(it) }
    }

    private fun inputCarNames(): List<String> {
        val input = Console.readLine().split(",")
        CarValidation().checkNameInputValidation(input)
        return input
    }
}