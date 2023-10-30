package racingcar.generator

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {
    fun generate(): Int = Randoms.pickNumberInRange(1, 9)
}