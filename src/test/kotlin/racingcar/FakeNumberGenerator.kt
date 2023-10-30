package racingcar

class FakeNumberGenerator : NumberGenerator {
    override fun generateNumber(): Int {
        return 4
    }
}