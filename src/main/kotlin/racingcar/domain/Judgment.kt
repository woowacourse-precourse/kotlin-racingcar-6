package racingcar.domain

import racingcar.constant.Constants.MIN_FORWARD_THRESHOLD

class Judgment {
    fun canMoveForward(randomNumber: Int): Boolean {
        return randomNumber >= MIN_FORWARD_THRESHOLD
    }
}
