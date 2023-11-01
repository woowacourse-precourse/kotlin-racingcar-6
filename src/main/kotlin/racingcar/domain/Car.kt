package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

private val MIN_POWER = 4

class Car(var name: String) {
    var position = 0
    fun move(num :Int) {
        if (num >= MIN_POWER) position++
    }

    fun getResult() : String {
        var distance = "${this.name} : "
        repeat(position) {
            distance += "-"
        }
        return distance
    }

    fun getRandoms() : Int {
        return Randoms.pickNumberInRange(0, 9)
    }

}

