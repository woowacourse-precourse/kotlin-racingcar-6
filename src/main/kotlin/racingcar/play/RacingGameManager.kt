package racingcar.play

import racingcar.ui.UserInput
import racingcar.ui.UserInput.createNameList

object RacingGameManager {
    private var carNames: List<String> = listOf()
    private var racingCars: MutableList<RacingCar> = mutableListOf()
    fun play() {
        registerCarNames()
    }

    private fun registerCarNames() {
        carNames = UserInput.readCarName()
            .createNameList()

        for (name in carNames) {
            racingCars.add(RacingCar(name))
        }
    }

}