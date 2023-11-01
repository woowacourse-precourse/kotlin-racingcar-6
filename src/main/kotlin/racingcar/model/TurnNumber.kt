package racingcar.model

@JvmInline
value class TurnNumber(val number: Int) {
    init {
        require(number >= MIN_TURN_NUMBER) { LESS_THAN_MIN_TURN_NUMBER_EXCEPTION }
    }

    companion object {
        const val MIN_TURN_NUMBER = 0
        const val LESS_THAN_MIN_TURN_NUMBER_EXCEPTION = "Turn number must be greater than or equal to $MIN_TURN_NUMBER"
    }
}