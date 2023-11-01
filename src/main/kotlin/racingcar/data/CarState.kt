package racingcar.data

enum class CarState(val symbol: String) {
    MOVING_FORWARD("-"), STOP("");

    companion object {
        private const val MOVE_CRITERIA = 4
        fun toCarState(value: Int): CarState = if (value >= MOVE_CRITERIA) MOVING_FORWARD else STOP
    }
}