package racingcar.play

import racingcar.ui.UserInput
import racingcar.ui.UserInput.createNameList

object RacingGameManager {
    private var carNames: List<String> = listOf()
    private var racingCars: MutableList<RacingCar> = mutableListOf()
    private var attemptCount: Int = 0
    fun play() {
        registerCarNames()
        getAttemptCount()
    }

    private fun registerCarNames() {
        carNames = UserInput.readCarName()
            .createNameList()
        // (예정사항) carNames를 넘겨 입력 유효성 검사.
        for (carName in carNames) {
            racingCars.add(RacingCar(name = carName))
        }
    }

    private fun getAttemptCount() {
        val input = UserInput.readAttemptCount()
        // (예정사항) input을 넘겨 입력 유효성 검사.
        attemptCount = input.toInt()
    }



}