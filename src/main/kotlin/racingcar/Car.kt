package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {

    var moveCount = 0

    init {
        if (name.length > 5) {
            throw IllegalArgumentException("차의 이름은 5자 이하만 가능합니다.")
        }
    }

    fun moveCar() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moveCount++
        }
    }
}