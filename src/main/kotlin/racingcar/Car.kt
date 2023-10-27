package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var distance: Int) {
    companion object {
        const val distanceString = "-"
    }
    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if(randomNumber >= 4) distance += 1
    }
    fun printState() {
        val sb = StringBuilder()
        for(i in 0 until distance) {
            sb.append(distanceString)
        }
        println("$name : $sb")
    }
}