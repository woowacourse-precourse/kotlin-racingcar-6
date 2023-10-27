package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.MOVING_MORE_NUMBER
import racingcar.constants.RANDOM_END_NUMBER
import racingcar.constants.RANDOM_START_NUMBER

class RacingGame {

    fun isMovingForward(number: Int): Boolean {
        return number >= MOVING_MORE_NUMBER
    }
}