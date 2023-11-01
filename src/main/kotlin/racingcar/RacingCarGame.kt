package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.utils.Constants

class RacingCarGame {
    private val user = UserInput()
    private var racingCars: List<RacingCar> = listOf()
    private var trial: Int = 0
    fun startGame() {
        racingCars = user.getNameInput()
        trial = user.getTrialInput()

        println(Constants.RESULT_MESSAGE)
        repeat(trial) {
            playEachRound()
        }
        printFinalWinner()
    }

    private fun playEachRound() {
        repeat(racingCars.size) {
            if (Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM) >= LIMIT_FOR_MOVING) {
                racingCars[it].location++
            }
        }
        racingCars.forEach { println(it.toString()) }
        println()
    }

    private fun printFinalWinner() {
        val sortedRacingCar: List<RacingCar> = racingCars.sorted()
        val winnerLocation = sortedRacingCar.first().location

        print(Constants.FINAL_WINNER_MESSAGE)
        println(sortedRacingCar.filter {
            it.location == winnerLocation
        }.joinToString(separator = ", ", transform = { car -> car.carName }))
    }

    companion object {
        const val MIN_RANDOM_NUM = 0
        const val MAX_RANDOM_NUM = 9
        const val LIMIT_FOR_MOVING = 4
    }
}