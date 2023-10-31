package racingcar

import racingcar.model.RacingCar

class RacingCarGame {
    private val user = UserInput()
    private var racingCars: List<RacingCar> = listOf()
    private var trial: Int = 0
    fun startGame() {
        racingCars = user.getNameInput()
        trial = user.getTrialInput()
    }
}