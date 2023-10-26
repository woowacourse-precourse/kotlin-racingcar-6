package racingcar.game

import racingcar.game.PrintUtil.printStartMessage

class RacingGame {
    private lateinit var racingCars: List<Car>

    fun start() {
        printStartMessage()
        inviteRacer()
    }

    private fun inviteRacer() {
        racingCars = UserInput.getRacingCars()
    }
}