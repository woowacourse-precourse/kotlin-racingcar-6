package racingcar.attempts

class AttemptsImpl : Attempts {
    private var _attempt: Int = ZERO
    override val attempt: Int
        get() = TODO("Not yet implemented")

    override fun setAttempt(attempt: Int) {
        _attempt = attempt
    }

    companion object {
        private const val ZERO = 0
    }
}
