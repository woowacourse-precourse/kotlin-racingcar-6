package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import java.util.Random

class RandomNumberGenerator {
    fun Generator(): Int {
        val num = Randoms.pickNumberInRange(Constants.MIN, Constants.MAX)
        return num
    }
}