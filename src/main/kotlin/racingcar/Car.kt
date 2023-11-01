package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

const val FORWARDABLE_NUMBER = 4

class Car(val name: String) {
    var forwardCount = 0
        private set

    fun forwardCar() {
        if (pickNumberInRange(0, 9) >= FORWARDABLE_NUMBER) forwardCount++
    }

    // 테스트를 위한 코드
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        return name == other.name
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + forwardCount
        return result
    }
}