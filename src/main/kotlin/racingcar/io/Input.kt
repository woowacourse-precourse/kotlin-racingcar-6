package racingcar.io

import camp.nextstep.edu.missionutils.Console

class Input {

    fun enterCarNames():List<String> {
        val carNames = Console.readLine().split(',')

        return carNames
    }

    fun enterTryNumber(): Int {
        val tryNumber = Console.readLine().toInt()

        return tryNumber
    }
}