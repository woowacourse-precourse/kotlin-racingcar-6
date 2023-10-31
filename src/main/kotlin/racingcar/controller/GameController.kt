package racingcar.controller

import racingcar.domain.CarNames
import racingcar.domain.MoveTimes
import racingcar.domain.RacingGame
import racingcar.view.GameView

class GameController(
    private val gameView: GameView,
    private val carNames: CarNames,
    private val moveTimes: MoveTimes,
    private val racingGame: RacingGame
) {
    fun run() {
        gameView.requireName()
        carNames.inputCarNames()

        gameView.requireMoveTimes()
        moveTimes.inputMoveTimes()

        gameView.startRacing()
        raceLoop()
    }

    private fun raceLoop() {
        racingGame.initRaceState(carNames.getNameList())

        for (i in 1..moveTimes.getMoveTime()) {
            val progress = racingGame.race(carNames.getNameList().size)
            racingGame.updateRaceState(progress)
            gameView.showCurrentRace(racingGame.getRaceState())
        }
    }
}