package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.Exceptions
import racingcar.strings.Strings

object ConsoleView {
    fun inputCarNames(): List<String> {
        println(Strings.MESSAGE_START_GAME)
        val input = Console.readLine()

        return Exceptions.inputCarNameException(input)
    }

    fun inputTryCount(): Int {
        println(Strings.MESSAGE_INPUT_TRY_COUNT)
        val tryCount = Console.readLine()
        return Exceptions.inputTryCountException(tryCount)
    }

    fun printRound(round: Int) {
        println("\n$round " + Strings.MESSAGE_ROUND)
    }

    fun printDistances(distances: Map<String, Int>) {
        distances.forEach { (name, distance) ->
            println("$name : ${"-".repeat(distance)}")
        }
    }

    fun printWinner(winners: Set<String>) {
        if (winners.size == 1) {
            println("\n" + Strings.MESSAGE_WINNER + winners.first())
        } else {
            println("\n" + Strings.MESSAGE_WINNER + winners.joinToString(", "))
        }
    }
}
