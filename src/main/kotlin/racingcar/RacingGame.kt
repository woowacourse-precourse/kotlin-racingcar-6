package racingcar

import racingcar.GameMessage.GAME_RESULT_MESSAGE

class RacingGame(
    private val racingCarInput: RacingCarInput,
    private val moveCountInput: MoveCountInput,
    private val raceManager: RaceManager,
    private val racePrinter: RacePrinter
) {
    fun start() {
        val cars = racingCarInput.getCarNames()
        showNumberInputMessage()
        val count = UserInput.getUserInput().let {
            moveCountInput.getMoveCount(it)
        }
        raceManager.setup(cars)
        runRace(count)
        val winners = raceManager.findWinners()
        racePrinter.showWinners(winners)
    }

    private fun showNumberInputMessage() {
        println(GameMessage.INPUT_NUMBER_ATTEMPTS_MESSAGE)
    }

    private fun runRace(count: Int) {
        println(GAME_RESULT_MESSAGE)
        repeat(count) {
            val currentRace: List<Car> = raceManager.race()
            racePrinter.showCurrentRace(currentRace)
        }
    }
}
