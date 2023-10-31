package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(private val name: String) {
    var position: Int = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }
}
