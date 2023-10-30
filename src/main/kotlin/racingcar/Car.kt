package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var position: Int = 0) {

    fun moving() {
        val num = Randoms.pickNumberInRange(1, 9)
        if (num >= 4) position++
    }

    fun printPosition() {
        var status = "${this.name} : "
        repeat(this.position) {
            status += "-"
        }
        println(status)
    }
}