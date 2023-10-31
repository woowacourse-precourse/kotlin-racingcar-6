package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {

    private var position = 0

    private fun findForwardCondition(): Boolean {
        return Randoms.pickNumberInRange(0, 9) > 3
    }

    fun move() {
        if (findForwardCondition()) {
            position++
        }
        print("$name : ${"-".repeat(position)}")
    }

}