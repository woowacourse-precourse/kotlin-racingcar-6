package racingcar.model

data class Car(
    private val inputName: String,
    private val scoreForTest: Int = CAR_SCORE_DEFAULT,
) {
    private var _name: String
    private var _score: Int

    internal val name: String get() = _name
    internal val score: Int get() = _score

    init {
        // val inputNameTrim = inputName.trim()
        checkNameLength(inputName)
        checkNameLetter(inputName)
        _name = inputName

        require(scoreForTest >= CAR_SCORE_DEFAULT) { CAR_SCORE_IS_NEGATIVE }
        _score = scoreForTest
    }

    // TODO : 최종 테스트 후, 가시성 제한하기
    private fun checkNameLength(inputNameTrim: String) =
        require(inputNameTrim.length in CAR_NAME_MIN..CAR_NAME_MAX) { CAR_NAME_LENGTH_ERROR }

    private fun checkNameLetter(inputNameTrim: String) =
        require(inputNameTrim.all { it.isDigit() || it.isLetter() }) { CAR_NAME_FORMAT_ERROR }


    internal fun moveForward() = _score++

    companion object {
        internal const val CAR_SCORE_DEFAULT = 0
        internal const val CAR_SCORE_IS_NEGATIVE = "테스트를 위해 입력된 숫자가 음수입니다."

        internal const val CAR_NAME_MIN = 1
        internal const val CAR_NAME_MAX = 5

        internal const val CAR_NAME_LENGTH_ERROR =
            "자동차 이름은 ${CAR_NAME_MIN}자 이상 ${CAR_NAME_MAX}자 이하로 입력해주세요."
        internal const val CAR_NAME_FORMAT_ERROR = "자동차 이름은 한글, 영문, 숫자만 사용할 수 있습니다."


    }
}