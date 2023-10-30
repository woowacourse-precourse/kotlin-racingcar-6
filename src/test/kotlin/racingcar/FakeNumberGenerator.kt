package racingcar

class FakeNumberGenerator(private val input : Int) : NumberGenerator {
    override fun generateNumber(): Int {
        return input
    }
}