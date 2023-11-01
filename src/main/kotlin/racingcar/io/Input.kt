package racingcar.io

import camp.nextstep.edu.missionutils.Console
import racingcar.exception.ExceptionChecker

class Input(private val exceptionChecker: ExceptionChecker = ExceptionChecker()) {

    fun enterCarNames(): List<String> {
        val carNames = Console.readLine().split(',')
        exceptionChecker.checkCarNames(carNames)

        return carNames
    }

    fun enterTryNumber(): Int {
        val tryNumber = Console.readLine()
        exceptionChecker.checkTryNumber(tryNumber)

        return tryNumber.toInt()
    }
}