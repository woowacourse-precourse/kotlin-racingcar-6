package racingcar

import racingcar.car.Car
import racingcar.constants.GameInstruction

class RacingGame(
    private val player: Player = Player(),
    private val monitor: Monitor = Monitor(),
) {
    fun play() {
        monitor.display(GameInstruction.ENTER_CAR_NAMES)
        val cars: List<Car> = generateCars(player.determineCarNames())
        val attemptCount: Int = generateAttemptCount()
        val race = Race(attemptCount, cars).apply { start(this) }
        monitor.display(race.winner)
    }

    private fun start(race: Race) {
        monitor.display(GameInstruction.RACING_RESULT)
        while (race.isRunning) {
            val result = race.runOneStep()
            monitor.display(result)
        }
    }

    private fun generateCars(carNames: List<String>) = carNames.map { name -> Car(name) }

    private fun generateAttemptCount(): Int {
        monitor.display(GameInstruction.ATTEMPT_COUNT)
        return player.determineAttemptCount()
    }
}