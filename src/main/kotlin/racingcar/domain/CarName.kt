package racingcar.domain

class CarName(name: String) {
    private val name: String

    init {
        val trimmedName = name.trim()
        require(trimmedName.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { "자동차 이름은 ${MIN_NAME_LENGTH}자 이상 ${MAX_NAME_LENGTH}자 이하만 가능합니다." }
        this.name = trimmedName
    }

    override fun toString() = name

    companion object {
        private const val MIN_NAME_LENGTH = 1
        private const val MAX_NAME_LENGTH = 5
    }
}