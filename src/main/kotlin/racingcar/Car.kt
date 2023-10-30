package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    private var position = 0


    fun move() {
        val random = Randoms.pickNumberInRange(0, 9)
        if (random >= 4) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }

    fun getCurrentPosition() {
        println("$name : ${"-".repeat(position)}")
    }
    fun getCarName(): String {
        return name
    }

}