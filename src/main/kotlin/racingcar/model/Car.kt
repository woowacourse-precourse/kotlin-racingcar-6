package racingcar.model

data class Car(
    val name: String,
    var position: Int = 0
) {
    init {
        require(name.isNotBlank()) { BLANK_NAME }
        require(name.length <= NAME_MAX_LENGTH) { TOO_LONG_NAME }
    }

    fun moveForward() {
        position++
    }

    companion object {
        private const val NAME_MAX_LENGTH = 5
        const val TOO_LONG_NAME = "자동차의 이름은 ${NAME_MAX_LENGTH}자 이하만 가능합니다."
        const val BLANK_NAME = "자동차의 이름은 공백일 수 없습니다."
    }
}