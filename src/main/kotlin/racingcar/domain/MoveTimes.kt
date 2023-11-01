package racingcar.domain

import racingcar.utils.InputChecker

class MoveTimes(
    private val inputChecker: InputChecker,
    private var moveTime: Int = 0
) {
    fun inputMoveTimes(input: String): Int {
        moveTime = inputChecker.checkMoveTimes(input).toInt()

        return moveTime
    }

    fun getMoveTime(): Int = moveTime
}