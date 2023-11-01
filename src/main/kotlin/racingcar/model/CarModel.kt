package racingcar.model

import racingcar.util.MOVE_CONDITION
import racingcar.validation.InputValidation

class CarModel {
    private var carNames: List<String> = emptyList()
    private var attemptsNumber: Int = 0
    private val progressList: MutableList<Int> = mutableListOf()

    fun setCarNames(names: List<String>) {
        carNames = InputValidation().validateCarNames(names)
    }

    fun setAttemptsNumber(attempts: Int) {
        attemptsNumber = InputValidation().validateAttemptsNumber(attempts)
    }

    fun initProgressList() {
        for (i in carNames.indices) {
            progressList.add(0)
        }
    }

    fun moveCar() {
        val randomNumber = RandomNumber()
        for (i in 0..carNames.size - 1) {
            val random = randomNumber.generateRandomNumber()
            if (random >= MOVE_CONDITION) {
                moveCarForward(i)
            }
        }
    }

    fun moveCarForward(index: Int) {
        progressList[index]++
    }

    fun getCarProgress(index: Int): Int {
        return progressList[index]
    }

    fun getMaxProgress(): Int {
        return progressList.maxOrNull() ?: 0
    }
}