package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(private val cars: List<Car>, private val numberOfRounds: Int) {
    fun start(): List<Map<String, Int>> {
        return List(numberOfRounds) { playRound() }
    }

    private fun playRound(): Map<String, Int> {
        return cars.associate { car ->
            val randomValue = Randoms.pickNumberInRange(0, 9)
            car.move(randomValue)
            car.getName() to car.getPosition()
        }
    }

}