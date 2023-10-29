package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(private val name: String) {
    private var position: Int = 0

    fun printCarData() {
        print("$name : ")
        repeat(position) {
            print("-")
        }
    }
    fun isAdvance (): Int {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
}
