package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Constants.MOVE_SIGN

object RacingGame {

    fun getResult(racingCars: List<RacingCar>): List<RacingCar> {
        val numbers = pickNumbers(racingCars.size)

        racingCars.zip(numbers) { car, number ->
            if (number >= 4) {
                car.moves += 1
            }
        }

        logResult(racingCars)

        return racingCars
    }

    private fun logResult(racingCars: List<RacingCar>) {
        racingCars.onEach {
            val moves = MOVE_SIGN.repeat(it.moves)
            println("${it.name} : $moves")
        }

        println()
    }

    private fun pickNumbers(players: Int): List<Int> {
        val numbers = mutableListOf<Int>()

        repeat(players) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            numbers.add(randomNumber)
        }

        return numbers
    }
}