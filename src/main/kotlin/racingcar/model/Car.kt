package racingcar.model

data class Car(
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
        if (randomNumber >= 4) {
            return true
        }
        return false
    }
}

internal fun Car.validateCar() {
    when {
        name.isBlank() -> {
            throw IllegalArgumentException("올바른 이름을 입력해주세요.")
        }

        name.length > 5 -> {
            throw IllegalArgumentException("이름은 5자 이하까지 입력 가능합니다.")
        }
    }
}