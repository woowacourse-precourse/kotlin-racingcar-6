package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, position: Int = 0) {
    var position = position
        private set

    fun moving() {
        val num = Randoms.pickNumberInRange(1, 9)
        if (num >= 4) position++
    }
}