package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame {

    private fun userInput() = Console.readLine()

    fun playRacing() {
        val printer = Printer()
        printer.printOutEnteringCarName()
        val cars = userInput()
    }
}