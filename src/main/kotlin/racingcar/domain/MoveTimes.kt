package racingcar.domain

import racingcar.io.Reader
import racingcar.utils.InputChecker

class MoveTimes(
    private val reader: Reader,
    private val inputChecker: InputChecker,
    private var moveTime: Int = 0
) {
    fun inputMoveTimes(): Int {
        moveTime = inputChecker.checkMoveTimes(reader.readLine()).toInt()

        return moveTime
    }

    fun getMoveTime(): Int = moveTime
}