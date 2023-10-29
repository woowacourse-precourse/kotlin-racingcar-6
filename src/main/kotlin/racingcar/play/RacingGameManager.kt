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
                println()
            }
            println()
        }
        return this
    }

    fun announceWinner() {
        val winner = whoIsWinner(racingCars)
        UserOutput.printWinner(winner)
    }

    /**
     * 1. getMaxDistance에 RacingCars 리스트를 넣고, distance의 최댓값을 구한다.
     * 2. hasmaxDistance에 RacingCars 리스트와 distance의 최댓값을 넣어
     *    최댓값을 가진 객체들의 name 리스트를 반환한다.
     */
    private fun whoIsWinner(cars: MutableList<RacingCar>): List<String> {
        return hasMaxDistance(cars, getMaxDistance(cars))
    }

    private fun getMaxDistance(cars: MutableList<RacingCar>): Int {
        return cars.maxOf { it.distance }
    }

    private fun hasMaxDistance(cars: MutableList<RacingCar>, max: Int): List<String> {
        return cars.filter { it.distance == max }.map { it.name }
    }
}