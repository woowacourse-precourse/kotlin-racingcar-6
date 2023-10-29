package racingcar.model

data class Car(
    private var inputName: String,
) {
    private var _name: String
    private var _score: Int = CAR_SCORE_DEFAULT

    val name: String get() = _name
    val score: Int get() = _score

    init {
        inputName = inputName.trim()
        println("inputName : $inputName (length: ${inputName.length})") // TODO : 디버깅 출력문 제거
        checkNameLength()
        checkNameLetter()
        _name = inputName
    }

    private fun checkNameLength() =
        require(inputName.length in CAR_NAME_MIN..CAR_NAME_MAX) { CAR_NAME_LENGTH_ERROR }

    private fun checkNameLetter() =
        require(inputName.all { it.isDigit() || it.isLetter() }) { CAR_NAME_FORMAT_ERROR }

    internal fun moveForward() = _score++

    companion object {
        private const val CAR_SCORE_DEFAULT = 0

        private const val CAR_NAME_MIN = 1
        private const val CAR_NAME_MAX = 5

        private const val CAR_NAME_LENGTH_ERROR =
            "자동차 이름은 ${CAR_NAME_MIN}자 이상 ${CAR_NAME_MAX}자 이하로 입력해주세요."
        private const val CAR_NAME_FORMAT_ERROR = "자동차 이름은 한글, 영문, 숫자만 사용할 수 있습니다."
    }
}