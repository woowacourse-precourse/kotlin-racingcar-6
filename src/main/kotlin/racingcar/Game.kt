package racingcar

import camp.nextstep.edu.missionutils.Console

class Game(
    private val printer: Printer = Printer(),
    private val presenter: RacingPresenter = RacingPresenter()
) {

    private fun inputRacingCars() {
        printer.printInputRacingCarNamesMessage()
        val nameInput = Console.readLine()
        presenter.createRacingCarsOrThrow(nameInput)
    }

    private fun inputTryTime(): TryTime {
        printer.printInputTryTimeMessage()
        val input = Console.readLine()
        return TryTime.createOrThrow(input)
    }

    private fun runGame(tryTime: TryTime) {
        repeat(tryTime.count) {
            presenter.moveRacingCars()
            val cars = presenter.racingCars
            printer.printRacingCarStates(cars)
        }
    }

    private fun printWinners() {
        val winners = presenter.getWinners()
        val winnerNames = winners.map { it.name }
        printer.printWinners(winnerNames)
    }

    fun run() {
        inputRacingCars()
        val tryTime = inputTryTime()
        runGame(tryTime)
        printWinners()
    }
}