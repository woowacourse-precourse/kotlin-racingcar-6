package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    fun printPosition(): String {
        return "-".repeat(position)
    }
}