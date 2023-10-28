package racingcar.model

data class Car(private val inputName: String) {
    private var _name: String
    private var _score: Int = ZERO

    val name: String get() = _name
    val score: Int get() = _score

    companion object {
        private const val ZERO = 0
        private const val ALLOW_LENGTH_OF_CAR_NAME = 5
    }

    // TODO: 매직 스트링 제거, 디버깅 출력문 제거
    init {
        println("inputName : $inputName (length: ${inputName.length})")
        checkLengthWithinFive()
        checkDigitAndLetter()
        _name = inputName
    }

    private fun checkLengthWithinFive() =
        require(inputName.length <= ALLOW_LENGTH_OF_CAR_NAME) { "자동차 이름 : 1~5 길이로 작성해 주세요." }

    private fun checkDigitAndLetter() =
        require(inputName.all { it.isDigit() || it.isLetter() } ) { "자동차 이름 : 특수 문자는 포함될 수 없습니다." }

    internal fun moveForward() = _score++
}