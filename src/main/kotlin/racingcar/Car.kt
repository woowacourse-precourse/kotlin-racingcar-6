package racingcar

class Car(
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
    val name: String,
) {
    companion object {
        const val THRESHHOLD_FOR_MOVE_FORWARD = 4
        private const val MAX_NAME_LENGTH = 5
    }

    init {
        require(name.isNotEmpty() && name.length <= MAX_NAME_LENGTH) {
            "자동차의 이름은 1글자 이상, 5글자 이하여야 합니다."
        }
    }

    fun tryForwardMovement(): CarState {
        return when (isPossibleMoveForward()) {
            true -> CarState.MOVING_FORWARD
            false -> CarState.STOP
        }
    }

    private fun isPossibleMoveForward(): Boolean {
        return numberGenerator.generateNumber() >= THRESHHOLD_FOR_MOVE_FORWARD
    }
}