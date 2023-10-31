package racingcar

import racingcar.Constants.POSITION_STEP
import racingcar.Constants.START_POSITION

class RacingCar(
    val name: String,
    var position: Int = START_POSITION,
    private val moveStrategy: MoveStrategy
) {

    fun moveForward() {
        if (moveStrategy.canMove()) {
            position += POSITION_STEP
        }
    }
}