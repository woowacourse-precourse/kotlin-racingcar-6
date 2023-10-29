package racingcar.view

import camp.nextstep.edu.missionutils.Console

class ConsoleInputView : InputView {
    override fun readLine(): String {
        return Console.readLine()
    }

    override fun readInt(): Int {
        return requireNotNull(readLine().toIntOrNull()) { INPUT_NOT_NUMBER_EXCEPTION }
    }

    companion object {
        private const val INPUT_NOT_NUMBER_EXCEPTION = "Input must be a number"
    }
}