package racingcar.model

import racingcar.config.ExceptionMessage.INVALID_CAR_NAME
import racingcar.config.ExceptionMessage.TOO_LONG_NAME
import racingcar.config.GameConfig.MAX_CAR_NAME_LENGTH
import racingcar.config.GameConfig.MIN_THRESHOLD

class Car(
    val name: String,
    var position: Int = 0,
) {
    fun moveForward(numberGenerator: NumberGenerator = NumberGenerator()) {
        if (isMove(numberGenerator)) {
            position++
        }
    }

    private fun isMove(numberGenerator: NumberGenerator): Boolean {
        val randomNumber = numberGenerator.generateRandomNumber()
        if (randomNumber >= MIN_THRESHOLD) {
            return true
        }
        return false
    }

    override fun toString(): String {
        return "Car(name='$name', position=$position)"
    }
}

internal fun Car.validateCar() {
    when {
        name.isBlank() -> {
            throw IllegalArgumentException(INVALID_CAR_NAME)
        }

        name.length > MAX_CAR_NAME_LENGTH -> {
            throw IllegalArgumentException(TOO_LONG_NAME)
        }
    }
}