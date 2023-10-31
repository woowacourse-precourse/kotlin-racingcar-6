package racingcar.car

class CarImpl(override val name: String) : Car {
    private var _currentPosition: String = ""
    override val currentPosition: String
        get() = _currentPosition

    override fun forwardOrStop(randomNumber: Int) {
        _currentPosition += when (randomNumber) {
            in MINIMUM_OF_STOP..MAXIMUM_OF_STOP -> CarState.STOP.state
            in MINIMUM_OF_FORWARD..MAXIMUM_OF_FORWARD -> CarState.FORWARD.state
            else -> throw IllegalArgumentException()
        }
    }

    companion object {
        private const val MINIMUM_OF_STOP = 0
        private const val MAXIMUM_OF_STOP = 3
        private const val MINIMUM_OF_FORWARD = 4
        private const val MAXIMUM_OF_FORWARD = 9
    }
}