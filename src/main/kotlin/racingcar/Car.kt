package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(private val name: String) {
    private var carName = name
    private var position = 0

    fun increasePosition() {
        position++
    }

    fun generateRanNum() {
        val ranNum = Randoms.pickNumberInRange(0, 9)
        if (ranNum >= 4) increasePosition()
    }

    fun printPosition() {
        if (position == 0) {
            println("$carName : ")
        } else {
            val dashes = "-".repeat(position)
            println("$carName : $dashes")
        }
    }

    fun getPosition(): Int {
        return position
    }

    fun getCarName(): String {
        return carName
    }
}