package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Cars(carName: String) {
    var position = Constants.START_POSITION
    val name = carName

    fun move() {
        if (Randoms.pickNumberInRange(Constants.RANDOM_NUMBER_START, Constants.RANDOM_NUMBER_END) >= Constants.MOVING_CONDITION) {
            position++
        }
    }
}