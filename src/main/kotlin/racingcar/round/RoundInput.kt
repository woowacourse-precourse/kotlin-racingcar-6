package racingcar.round

import camp.nextstep.edu.missionutils.Console
class RoundInput {
    fun result(): Int {
        return inputRound()
    }

    private fun inputRound(): Int {
        val input = Console.readLine()
        RoundValidation().checkRoundInputValidation(input)
        return input.toInt()
    }
}
