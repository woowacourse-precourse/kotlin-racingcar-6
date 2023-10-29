package racingcar.model

data class Repetition(
    private val inputRepetition: String,
) {
    private var _count: Int
    val count: Int get() = _count

    init {
        checkDigitRange()
        _count = inputRepetition.toInt()
    }

    private fun checkDigitRange() {
        val inputRepetitionInt = inputRepetition.toIntOrNull()
            ?: throw IllegalArgumentException(ONLY_DIGIT)

        require(inputRepetitionInt >= MIN_REPETITION_COUNT) { DIGIT_THAN_ONE }

        _count = inputRepetitionInt
    }

    companion object {
        private const val MIN_REPETITION_COUNT = 1

        private const val ONLY_DIGIT = "숫자만 입력해 주세요"
        private const val DIGIT_THAN_ONE = "숫자는 1 이상이어야 합니다."
    }
}