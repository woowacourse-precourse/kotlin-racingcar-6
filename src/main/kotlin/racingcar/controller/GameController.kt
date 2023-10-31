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
        // 이름 입력
        gameView.printNameInput()
        carNames.inputCarNames()

        // 횟수 입력
        gameView.printMoveTimesInput()
        moveTimes.inputMoveTimes()

        // 횟수 만큼 이동
        gameView.printRacingStart()
        raceLoop()

        // 결과 출력
        gameView.printResult(racingGame.result())
    }

    private fun raceLoop() {
        racingGame.initRaceState(carNames.getNameList())

        for (i in 1..moveTimes.getMoveTime()) {
            val progress = racingGame.race(carNames.getNameList().size)
            racingGame.updateRaceState(progress)
            gameView.printRaceState(racingGame.getRaceState())
        }
    }
}