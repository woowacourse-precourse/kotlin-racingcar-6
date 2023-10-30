package racingcar

class Car(
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
    val name: String,
) {

    companion object{
        private const val THRESHHOLD_FOR_MOVE_FORWARD = 4
        private const val MAX_NAME_LENGTH = 5
    }

    init {
        require(name.isNotEmpty() && name.length <= MAX_NAME_LENGTH)
    }

    fun isPossibleMoveForward(): Boolean {
        return numberGenerator.generateNumber() >= THRESHHOLD_FOR_MOVE_FORWARD
    }
}