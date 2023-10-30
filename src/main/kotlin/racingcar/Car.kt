package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    private var position: Int = 0


    fun move() {
        val random = Randoms.pickNumberInRange(0, 9)
        if (random >= 4) {
            position++
        }
    }

}