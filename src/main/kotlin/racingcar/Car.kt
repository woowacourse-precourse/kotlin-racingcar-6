package racingcar

class Car(
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
    val name: String,
) {
    init {
        require(name.isNotEmpty() && name.length <= 5)
    }

    fun isPossibleMoveForward(): Boolean {
        return true
    }
}