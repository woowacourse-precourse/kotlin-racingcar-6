package racingcar.util

class StopNumberGenerator : NumberGenerator {
    override fun generate() = STOP

    companion object {
        const val STOP = 0
    }
}