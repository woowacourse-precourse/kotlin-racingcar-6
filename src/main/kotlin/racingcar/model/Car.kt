package racingcar.model

data class Car(
    val name: String,
    var position: Int,
) {
    fun moveForward() {
        if (isMove()) {
            position++
        }
    }

    private fun isMove(): Boolean {
        // TODO: NumberGenerator 에게 메시지 보내기
        return true
    }
}

internal fun Car.validateCar() {
    when {
        name.isBlank() -> {
            throw IllegalArgumentException("올바른 이름을 입력해주세요")
        }

        name.length > 5 -> {
            throw IllegalArgumentException("이름은 5자 이하까지 입력 가능합니다.")
        }
    }
}