package racingcar

import camp.nextstep.edu.missionutils.Console
class RoundInput {
    fun result(): Int {
        return inputRound()
    }

    // TODO 예외처리
    private fun inputRound(): Int {
        return Console.readLine().toInt()
    }
}
