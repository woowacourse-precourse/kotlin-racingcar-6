package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position: Int = 0

    companion object {
        const val ADVANCE_THRESHOLD = 4
    }
    fun printCarData() {
        print("$name : ")
        repeat(position) {
            print("-")
        }
        println("")
    }
    fun advancePosition () {
        if (Randoms.pickNumberInRange(0, 9) >= ADVANCE_THRESHOLD) {
            position++
        }
    }
}
