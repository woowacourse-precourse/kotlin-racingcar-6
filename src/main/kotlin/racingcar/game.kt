package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Game (private val cars: List<Car>, private val rounds: Int) {
    fun start() {
        println("실행 결과")
    }

    fun isAdvance (): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)

        if (randomNumber >= 4) {
            return 1
        }
        return 0
    }
}