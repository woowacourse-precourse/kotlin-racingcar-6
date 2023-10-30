package racingcar.play

import racingcar.ui.UserInput
import racingcar.ui.UserInput.createNameList
import racingcar.ui.UserOutput
import racingcar.ui.Validator

object RacingGameManager {
    private var carNames: List<String> = listOf()
    private var racingCars: MutableList<RacingCar> = mutableListOf()
    private var attemptCount: Int = 0
    fun init(): RacingGameManager {
        registerCarNames()
        getAttemptCount()
        return this
    }

    private fun registerCarNames() {
        carNames = UserInput.readCarName()
            .createNameList()
        Validator.checkNamesLength(carNames)
        for (carName in carNames) {
            racingCars.add(RacingCar(name = carName))
        }
    }

    private fun getAttemptCount() {
        val input = UserInput.readAttemptCount()
        // (예정사항) input을 넘겨 입력 유효성 검사.
        attemptCount = input.toInt()
    }

    fun startRace(): RacingGameManager {
        UserOutput.printResultMessage()
        for (i in 1..attemptCount) {
            racingCars.forEach {
                it.move()
                UserOutput.displayRoundResult(it.name, it.path)
            }
            println()
        }
        return this
    }

    fun announceWinner() {
        val winner = createWinnerList(racingCars)
        UserOutput.printWinner(winner)
    }

    private fun createWinnerList(cars: MutableList<RacingCar>): List<String> {
        return findCarNameWithMaxDistance(cars, getMaxDistance(cars))
    }

    private fun getMaxDistance(cars: MutableList<RacingCar>): Int {
        return cars.maxOf { it.distance }
    }

    private fun findCarNameWithMaxDistance(cars: MutableList<RacingCar>, max: Int): List<String> {
        return cars.filter { it.distance == max }.map { it.name }
    }
}