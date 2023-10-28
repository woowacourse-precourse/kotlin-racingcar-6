package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class RacingCar(
    val name: String,
    var location: Int = 0
) {

    private fun isAbleToMove(): Boolean {
        val random = Randoms.pickNumberInRange(0, 9)
        return (4 <= random)
    }
}