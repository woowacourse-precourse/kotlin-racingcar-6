package racingcar.controller

import racingcar.view.RaceView


class RaceController(
    private val raceView: RaceView
) {
    fun startRace() {
        raceView.displayEnterCarNames()
        val carNames = raceView.getCarNamesFromUser()

        raceView.displayEnterTurnNumber()
        val turnNumber = raceView.getTurnNumberFromUser()
    }
}