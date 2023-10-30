package racingcar

import racingcar.Car.Companion.THRESHHOLD_FOR_MOVE_FORWARD

class FakeNumberGenerator : NumberGenerator {
    override fun generateNumber(): Int {
        return THRESHHOLD_FOR_MOVE_FORWARD
    }
}