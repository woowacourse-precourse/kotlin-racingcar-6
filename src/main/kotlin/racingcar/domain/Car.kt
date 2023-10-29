package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import java.lang.StringBuilder

class Car(private val name: String) {
    private var position = 0

    fun moveOrStay() {
        if (isMovable()) {
            position++
        }
    }

    fun showCurrentPositionWithName() {
        val positionString = "-".repeat(position)
        val result = "$name : $positionString"
        println(result)
    }

    private fun isMovable(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}