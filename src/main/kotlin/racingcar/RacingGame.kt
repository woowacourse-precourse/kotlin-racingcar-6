package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.MOVING_MORE_NUMBER
import racingcar.constants.RANDOM_END_NUMBER
import racingcar.constants.RANDOM_START_NUMBER

class RacingGame {

    fun isMovingForward(): Boolean {
        return Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER) >= MOVING_MORE_NUMBER
    }
}