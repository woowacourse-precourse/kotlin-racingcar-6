package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Exception.requireValidCarNames


class InputView {

    fun inputRacingCarNames(): List<String> {
        val carNames = Console.readLine()
        carNames.requireValidCarNames()
        return carNames.trim().split(",")
    }
}