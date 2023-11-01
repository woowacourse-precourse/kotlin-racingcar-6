package racingcar

import camp.nextstep.edu.missionutils.Randoms

const val START_RANDOM_NUMBER = 0
const val END_RANDOM_NUMBER = 9
const val CAN_MOVE_FORWARD_NUMBER = 4

class Car(val name: String, var forwardCount: Int = 0) {
    fun tryMoveForward() {
        val randomNumber = Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER)
        if (randomNumber >= CAN_MOVE_FORWARD_NUMBER) {
            forwardCount += 1
        }
    }
}