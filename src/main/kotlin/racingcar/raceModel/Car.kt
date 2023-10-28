package racingcar.raceModel

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    init {
        if (name.length > 5) {
            throw IllegalArgumentException()
        }
    }

    var position: Int = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    override fun toString() = "$name : ${"-".repeat(position)}"
}