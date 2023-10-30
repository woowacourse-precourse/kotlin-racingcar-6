package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingGameModel {
    class Car(val name: String) {
        var distance: Int = 0
            private set

        fun move() {
            val randomValue = Randoms.pickNumberInRange(0, 9)
            if (randomValue >= 4) {
                distance++
            }
        }
    }

    class RacingGame(val carNames: List<String>, val tryCount: Int) {
        private val cars = carNames.map { Car(it) }

        fun playRound() {
            cars.forEach { it.move() }
        }

        fun getResults(): Map<String, Int> {
            return cars.associateBy({ it.name }, { it.distance })
        }
    }
}