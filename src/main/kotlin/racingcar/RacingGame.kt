package racingcar

import camp.nextstep.edu.missionutils.Randoms

object RacingGame {

    fun getResult(racingCars: List<RacingCar>): List<RacingCar> {
        val numbers = pickNumbers(racingCars.size)

        racingCars.zip(numbers) { car, number ->
            if (number >= 4) {
                car.moves += 1
            }
        }

        return racingCars
    }

    fun pickNumbers(players: Int): List<Int> {
        val numbers = mutableListOf<Int>()
        repeat(players) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            numbers.add(randomNumber)
        }

        return numbers
    }
}