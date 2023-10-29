package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {
    override fun generate() = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)

    companion object{
        const val MAX_NUMBER = 9
        const val MIN_NUMBER = 1
    }

}