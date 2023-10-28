package racingcar.model

data class Repetition(private val inputRepetition: String) {
    private var _count: Int

    val count: Int get() = _count

    // TODO: 매직 스트링 제거, 디버깅 출력문 제거
    init {
        checkDigitRange()
        _count = inputRepetition.toInt()
    }

    private fun checkDigitRange() {
        require(inputRepetition.all { it.isDigit() }) { "숫자만 입력해주세요." }

        val inputRepetitionInt = inputRepetition.toInt()
        require(inputRepetitionInt >= 1) { "1이상의 숫자를 입력해주세요." }

        _count = inputRepetitionInt
        println("Repetition.count : $count")
    }
}