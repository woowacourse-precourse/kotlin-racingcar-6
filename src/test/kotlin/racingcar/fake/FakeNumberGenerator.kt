package racingcar.fake

import racingcar.NumberGenerator

class FakeNumberGenerator(private val input : Int) : NumberGenerator {
    override fun generateNumber(): Int {
        return input
    }
}