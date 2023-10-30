package racingcar

import racingcar.GameMessage.GAME_RESULT_MESSAGE

class RacingGame(
    private val racingCarInput: RacingCarInput,
    private val moveCountInput: MoveCountInput,
    private val raceManager: RaceManager,
    private val racePrinter: RacePrinter
) {

    private fun runRace(count: Int) {
        println(GAME_RESULT_MESSAGE)
        repeat(count) {
            val currentRace: List<Car> = raceManager.race()
            racePrinter.showCurrentRace(currentRace)
        }
    }
}
