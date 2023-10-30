package racingcar.view

import racingcar.Constants
import camp.nextstep.edu.missionutils.Console
import racingcar.domain.car.CarNames

object InputView {
    fun readNames(): CarNames {
        OutputView.startReadNames()
        val input = Console.readLine() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        val carNames = input.split(",")
        return CarNames(carNames)
    }

    fun readCount(): Int {
        OutputView.startReadCount()
        val input = Console.readLine() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        return input.toInt()
    }
}
