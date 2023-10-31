package racingcar

import racingcar.model.RacingCar

class RacingCarGame {
    private val user = UserInput()
    private var racingCars: List<RacingCar> = listOf()

    fun startGame() {
        racingCars = user.getNameInput()
    }
}