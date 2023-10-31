package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

const val FORWARDABLE_NUMBER = 4

class Car(val name: String) {
    var forwardCount = 0
        private set

    fun forwardCar() {
        if (pickNumberInRange(0, 9) >= FORWARDABLE_NUMBER) forwardCount++
    }
}