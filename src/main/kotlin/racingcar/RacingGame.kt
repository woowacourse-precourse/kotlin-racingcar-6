package racingcar

import racingcar.constants.GameInstruction

class RacingGame(
    private val player: Player = Player(),
    private val monitor: Monitor = Monitor(),
) {
    fun play() {
        val cars: List<Car> = generateCars(player.determineCarNames())
        val attemptCount: Int = generateAttemptCount()
        val race = Race(attemptCount, cars).apply { start(this) }
        monitor.display(race.winner)
    }

    private fun start(race: Race) {
        monitor.display(GameInstruction.RACING_RESULT)
        while (race.isRunning) {
            race.runOnStep()
            monitor.display(race.result)
        }
    }

    private fun generateCars(carNames: List<String>): List<Car> {
        monitor.display(GameInstruction.ENTER_NUMBER)
        return carNames.map { name -> RacingCar(name) }
    }

    private fun generateAttemptCount(): Int {
        monitor.display(GameInstruction.ATTEMPT_COUNT)
        return player.determineAttemptCount()
    }
}