package racingcar.exception

class CycleValidation(private val number: String) : Exception {
    init {
        checkEmpty()
        checkCycleString()
        checkZero()
    }

    private fun checkCycleString() {
        val length = number.length
        require(number.matches(Regex("[0-9]{$length}"))) {
            "숫자만 입력해 주세요."
        }
    }

    private fun checkZero() {
        require(number.toInt() != 0) {
            "이동 횟수는 1이상 입력해 주세요"
        }
    }

    override fun checkEmpty() {
        require(number.isNotEmpty()) {
            "값을 입력해주세요."
        }
    }
}