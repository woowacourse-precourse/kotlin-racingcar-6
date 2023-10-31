package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String) {
     var distance: Int = 0
    fun checkMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++
            println("여기 name $name")
            println("distance $distance")
        }
    }

    fun display(): String {
        return "$name : ${GO.repeat(distance)}"

    }

    companion object {
        const val STOP = ""
        const val GO = "-"
    }
}
