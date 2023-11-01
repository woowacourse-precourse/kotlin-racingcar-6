package racingcar.randomnumbergenerator

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGeneratorImpl : RandomNumberGenerator {
    override fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}