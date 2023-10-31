package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validator.Validator

object InputView {
    private const val COMMA = ","

    fun askCarToRace(validator: Validator): List<String> {
        val carsName = Console.readLine().split(COMMA)

        for (name in carsName) {
            validator.nameLength(name)
        }

        return carsName
    }

    fun askNumberOfAttempts(validator: Validator): Int {
        val numberOfAttempts = Console.readLine()

        validator.attemptsComponents(numberOfAttempts)

        return numberOfAttempts.toInt()
    }
}
