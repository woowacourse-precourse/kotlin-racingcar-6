package racingcar.model

@JvmInline
value class TurnNumber(val number: Int) {
    init {
        require(number >= MIN_TURN_NUMBER) { LESS_THAN_MIN_TURN_NUMBER }
    }

    companion object {
        private const val MIN_TURN_NUMBER = 0
        private const val LESS_THAN_MIN_TURN_NUMBER = "Turn number must be greater than $MIN_TURN_NUMBER"
    }
}