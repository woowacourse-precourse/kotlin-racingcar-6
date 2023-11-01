package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Exception.requireValidCarNames
import racingcar.utils.Exception.requirePositiveInt
import racingcar.utils.Exception.requireValidPositiveInt


class InputView {

    fun inputRacingCarNames(): List<String> {
        val carNames = Console.readLine()
        carNames.requireValidCarNames()
        return carNames.trim().split(",")
    }

    fun inputAttemptsNum(): Int {
        val attemptsNum = Console.readLine()
        attemptsNum.requireValidPositiveInt()
        attemptsNum.requirePositiveInt()
        return attemptsNum.toInt()
    }
}