package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validator.Validator

object InputView {
    private const val COMMA = ","

    fun askCarToRace(validator: Validator): List<String> {
        val cars = Console.readLine().split(COMMA)

        for (car in cars) {
            validator.nameLength(car)
        }

        return cars
    }

    fun askNumberOfAttempts(validator: Validator): Int {
        val numberOfAttempts = Console.readLine()

        validator.attemptsComponents(numberOfAttempts)

        return numberOfAttempts.toInt()
    }
}
