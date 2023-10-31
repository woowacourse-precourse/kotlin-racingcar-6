package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var position: Int = 0) {

    fun moving(num: Int) {
        if (num >= 4) position++
    }

    fun getStatus(): String {
        var status = "${this.name} : "
        repeat(this.position) {
            status += "-"
        }
        return status
    }

    fun generate() = Randoms.pickNumberInRange(1, 9)
}