package racingcar.util

class ForwardNumberGenerator : NumberGenerator {

    override fun generate() = MOVE

    companion object {
        const val MOVE = 5
    }
}