package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.MOVING_MORE_NUMBER

class RacingGame {

    fun isMovingForward(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= MOVING_MORE_NUMBER
    }
}