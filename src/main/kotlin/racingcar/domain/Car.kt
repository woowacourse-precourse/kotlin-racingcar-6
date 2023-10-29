package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(private val name: String) {
    private var position = 0

    fun moveOrStay() {
        if (isMovable()) {
            position++
        }
    }

    private fun isMovable(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}