package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class RacingCar(
    val name: String,
    var location: Int = 0
) {

    fun moveForward() {
        if (isAbleToMove()) {
            location += 1
        }
    }

    private fun isAbleToMove(): Boolean {
        val random = Randoms.pickNumberInRange(0, 9)
        return (4 <= random)
    }

    fun printLocation() {
        println("$name : ${"-".repeat(location)}")
    }
}