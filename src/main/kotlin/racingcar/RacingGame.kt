package racingcar

import camp.nextstep.edu.missionutils.Randoms

object RacingGame {

    fun pickNumbers(players: Int): List<Int> {
        val numbers = mutableListOf<Int>()
        repeat(players) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            numbers.add(randomNumber)
        }

        return numbers
    }
}