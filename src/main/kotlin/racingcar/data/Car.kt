package racingcar.data

data class Car(val name: String, private val trace: List<CarState>)

enum class CarState {
    MOVE, STOP;

    companion object {
        private const val MOVE_CRITERIA = 4
        fun toCarState(value: Int): CarState = if (value > MOVE_CRITERIA) MOVE else STOP
    }
}