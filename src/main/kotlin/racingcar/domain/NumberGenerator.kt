package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constant.Constants.START_INCLUSIVE
import racingcar.constant.Constants.END_INCLUSIVE

class NumberGenerator {
    fun createRandomNumber(): Int {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)
    }
}
