package racingcar.play

import racingcar.ui.InputValidator
import racingcar.ui.UserInput
import racingcar.ui.UserInput.createNameList
import racingcar.ui.UserOutput

object RacingGameManager {
    private var carNames: List<String> = listOf()
    private var racingCars: MutableList<RacingCar> = mutableListOf()
    private var attemptCount: Int = 0

    fun registerCarNames(): RacingGameManager {
        carNames = UserInput.readCarName()
            .createNameList()
        InputValidator.checkNamesLength(carNames) // 이름이 1자 이상 5자 이하인지 검사한다.
        for (carName in carNames) {
            racingCars.add(RacingCar(carName))
        }
        return this
    }

    fun getAttemptCount(): RacingGameManager {
        val input = UserInput.readAttemptCount()
        InputValidator.checkOnlyDigit(input)
        attemptCount = input.toInt()
        InputValidator.isPositive(attemptCount)
        return this
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

    fun announceWinner() = UserOutput.printWinner(createWinnerList(racingCars))

    private fun createWinnerList(cars: MutableList<RacingCar>): List<String> =
        findCarNameWithMaxDistance(cars, getMaxDistance(cars))

    private fun getMaxDistance(cars: MutableList<RacingCar>): Int =
        cars.maxOf { it.distance }

    private fun findCarNameWithMaxDistance(cars: MutableList<RacingCar>, max: Int): List<String> =
        cars.filter { it.distance == max }.map { it.name }
}