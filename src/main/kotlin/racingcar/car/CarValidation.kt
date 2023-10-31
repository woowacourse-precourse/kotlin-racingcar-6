package racingcar.car

class CarValidation {
    fun checkNameInputValidation(input: List<String>) {
        isInputWithinFiveChar(input)
        hasWhiteSpaceAtEdge(input)
        checkIsStartWithComma(input)
        checkIsEndWithComma(input)
        checkAtLeastTwoNames(input)
        checkIsSameName(input)
    }

    private fun isInputWithinFiveChar(list: List<String>) {
        if (list.any { it.length > MAX_LENGTH }) {
            throw IllegalArgumentException(MAX_INPUT_ERROR)
        }
    }

    private fun hasWhiteSpaceAtEdge(list: List<String>) {
        if (list.any { it.startsWith(' ') || it.endsWith(' ') }) {
            throw IllegalArgumentException(WHITE_SPACE_ERROR)
        }
    }

    private fun checkAtLeastTwoNames(list: List<String>) {
        if (list.count() < MIN_COUNT) {
            throw IllegalArgumentException(MIN_COUNT_ERROR)
        }
    }

    private fun checkIsStartWithComma(list: List<String>) {
        if (list.first().isEmpty()) {
            throw IllegalArgumentException(COMMA_START_ERROR)
        }
    }

    private fun checkIsEndWithComma(list: List<String>) {
        if (list.last().isEmpty()) {
            throw IllegalArgumentException(COMMA_END_ERROR)
        }
    }

    private fun checkIsSameName(list: List<String>) {
        if (list.toSet().size != list.size) {
            throw IllegalArgumentException(SAME_NAME_ERROR)
        }
    }

    companion object {
        const val MIN_COUNT = 2
        const val MAX_LENGTH = 5
        const val WHITE_SPACE_ERROR = "이름의 시작과 끝에는 공백 입력이 불가능합니다."
        const val MIN_COUNT_ERROR = "최소 2대이상의 자동차 이름이 입력되어야 게임 진행이 가능합니다."
        const val MAX_INPUT_ERROR = "자동차 이름은 5자 이하만 입력 가능합니다."
        const val COMMA_START_ERROR = "처음에 콤마가 추가되었습니다. 콤마로 입력을 시작해서는 안됩니다."
        const val COMMA_END_ERROR = "콤마로 입력이 끝나서는 안됩니다."
        const val SAME_NAME_ERROR = "중복된 이름이 있으면 안됩니다."
    }
}