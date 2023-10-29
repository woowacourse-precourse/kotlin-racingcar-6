package racingcar.model.car

class Car(
    val name: CarName,
    private val randomNumberGenerator: RandomNumberGenerator
) {
    var distance = 0
        private set

    fun tryGoForward() {
        val randomNumber = randomNumberGenerator.generateIntInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)

        if (randomNumber >= GO_FORWARD_THRESHOLD) {
            distance++
        }
    }

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
        private const val GO_FORWARD_THRESHOLD = 4
    }
}