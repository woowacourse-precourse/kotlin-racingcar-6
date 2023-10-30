package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position: Int = 0

    fun printCarData() {
        print("$name : ")
        repeat(position) {
            print("-")
        }
    }
    fun advancePosition () {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
}
